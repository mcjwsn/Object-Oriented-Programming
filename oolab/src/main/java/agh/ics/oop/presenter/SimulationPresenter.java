package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.util.List;

import static com.sun.javafx.application.ParametersImpl.getParameters;


public class SimulationPresenter implements MapChangeListener {
    private WorldMap worldMap;
    public void setWorldMap(WorldMap map) {
        this.worldMap = map;
    }


    public void drawMap(){
        System.out.println(worldMap.toString());
    };
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        setWorldMap(worldMap);
        Platform.runLater(() -> {
            drawMap();
            System.out.println(message);
        });
    }

}
