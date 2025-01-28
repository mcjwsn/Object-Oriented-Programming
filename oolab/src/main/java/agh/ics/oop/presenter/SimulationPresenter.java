package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap worldMap;
    private int pM, zM, pm, zm;
    private int currentMapWidth, currentMapHeight;

    @FXML private Label infoLabel;
    @FXML private TextField textField;
    @FXML private GridPane mapGrid;

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @FXML
    public void onSimulationStartClicked() {
        try {
            List<MoveDirection> directions = OptionsParser.parse(textField.getText().split(" "));
            AbstractWorldMap map = new GrassField(15);
            List<Vector2d> positions = List.of(
                    new Vector2d(2, 2), new Vector2d(8, 5),
                    new Vector2d(4, 4), new Vector2d(7, 6)
            );

            map.addObserver(this);
            map.addObserver((m, message) -> {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                System.out.printf("%s %s%n", timestamp, message);
            });

            FileMapDisplay fileObserver = new FileMapDisplay(map.getId());
            map.addObserver(fileObserver);

            setWorldMap(map);
            Simulation simulation = new Simulation(directions, positions, map);
            SimulationEngine engine = new SimulationEngine(List.of(simulation));
            engine.runAsync();

            infoLabel.setText("Simulation has started " + textField.getText());
        } catch (Exception e) {
            infoLabel.setText("Error" + e.getMessage());
        }
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            setWorldMap(worldMap);
            clearGrid();
            drawMap();
            infoLabel.setText(message);
        });
    }

    private void drawMap() {
        updateBounds();
        drawAxisLabels();
        drawColumns();
        drawRows();
        drawMapElements();
        mapGrid.setGridLinesVisible(true);
    }

    private void updateBounds() {
        pM = worldMap.getCurrentBounds().lowerLeft().getX();
        zM = worldMap.getCurrentBounds().lowerLeft().getY();
        pm = worldMap.getCurrentBounds().upperRight().getX();
        zm = worldMap.getCurrentBounds().upperRight().getY();
        currentMapWidth = pm - pM + 1;
        currentMapHeight = zm - zM + 1;
    }

    private void drawAxisLabels() {
        mapGrid.getColumnConstraints().add(new ColumnConstraints(25));
        mapGrid.getRowConstraints().add(new RowConstraints(25));

        Label axisLabel = new Label("y/x");
        mapGrid.add(axisLabel, 0, 0);
        GridPane.setHalignment(axisLabel, HPos.CENTER);
    }

    private void drawColumns() {
        for (int i = 0; i < currentMapWidth; i++) {
            Label label = new Label(Integer.toString(i + pM));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.getColumnConstraints().add(new ColumnConstraints(25));
            mapGrid.add(label, i + 1, 0);
        }
    }

    private void drawRows() {
        for (int i = 0; i < currentMapHeight; i++) {
            Label label = new Label(Integer.toString(zm - i));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.getRowConstraints().add(new RowConstraints(25));
            mapGrid.add(label, 0, i + 1);
        }
    }

    private void drawMapElements() {
        for (int i = pM; i <= pm; i++) {
            for (int j = zm; j >= zM; j--) {
                Optional<WorldElement> element = worldMap.objectAt(new Vector2d(i, j));

                if (!element.isPresent()) {
                    mapGrid.add(new Label(" "), i - pM + 1, zm - j + 1);
                } else {
                    mapGrid.add(new WorldElementBox(element.get()), i - pM + 1, zm - j + 1);
                }

                GridPane.setHalignment(mapGrid.getChildren().getLast(), HPos.CENTER);
            }
        }
    }

    private void clearGrid() {

        mapGrid.getChildren().retainAll(mapGrid.getChildren().getFirst());
        mapGrid.getColumnConstraints().clear();

        mapGrid.getRowConstraints().clear();


    }
}