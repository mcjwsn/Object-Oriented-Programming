package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationApp;
import agh.ics.oop.model.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static com.sun.javafx.application.ParametersImpl.getParameters;


public class SimulationPresenter implements MapChangeListener {
    public Button startButton;
    private WorldMap worldMap;
    public void setWorldMap(WorldMap map) {
        this.worldMap = map;
    }
    @FXML
    private Label infoLabel;
    @FXML
    private Label moveLabel;
    @FXML
    private TextField textField;
    @FXML
    private Button start;
    @FXML
    private GridPane mapGrid;
    @FXML
    private TextField mapTextField;

    public void drawMap(){
        if (worldMap != null) {
            infoLabel.setText(worldMap.toString());
        }
    };
    @FXML
    public void onSimulationStartClicked(){
        List<MoveDirection> directions = OptionsParser.parse(textField.getText().split(" "));
        AbstractWorldMap map1 = new GrassField(10);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        map1.addObserver(this);
        setWorldMap(map1);
        Simulation simulation1 = new Simulation(directions, positions, map1);
        SimulationEngine engine = new SimulationEngine(List.of(simulation1));
        //engine.runAsync();
        //infoLabel.setText("Simulation started with moves: " + moveLabel);
        new Thread(() -> {
            engine.runAsync();
        }).start();
    }
    @FXML
    private void newGame(){
        SimulationApp simulationApp = new SimulationApp();
        try {
            simulationApp.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        setWorldMap(worldMap);
        Platform.runLater(() -> {
            drawMap();
        });
    }
    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }

}
