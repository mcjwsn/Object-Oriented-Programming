package agh.ics.oop.presenter;

import agh.ics.oop.model.WorldMap;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class SimulationPresenter {
    private WorldMap map;
    public void setWorldMap(WorldMap map) {
        this.map = map;
    }
    @FXML
    private Label infoLabel;
}
