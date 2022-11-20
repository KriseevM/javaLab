package lab3.task1.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lab3.task1.logic.IClock;
import lab3.task1.logic.Unit;

import java.util.TreeMap;

public class addTimeFrameController {
    public VBox unitVBox;

    private IClock clock;
    private TreeMap<Unit, clockUnitAddPaneController> units = new TreeMap<>();
    public addTimeFrameController()
    {}
    public addTimeFrameController(IClock clock)
    {
        this.clock = clock;
    }
    @FXML
    public void initialize()
    {
        redraw();
    }

    private void redraw() {
        if(clock != null) {
            unitVBox.getChildren().clear();
            units.clear();
            for (Unit u : Unit.values()) {
                try {
                    // add 0 time so that if clock can't use specific unit u it will throw exception
                    clock.addTime(u, 0);
                    clockUnitAddPaneController controller = new clockUnitAddPaneController(u);
                    units.put(u, controller);
                    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("clockUnitAddPane.fxml"));
                    loader.setController(controller);
                    GridPane g = loader.load();
                    unitVBox.getChildren().add(g);
                }
                catch (Exception ignore) {}
            }
        }
    }

    public IClock getClock() {
        return clock;
    }

    public void setClock(IClock clock) {
        this.clock = clock;
        redraw();
    }

    public void CancelPress(ActionEvent actionEvent) {
        ((Stage)unitVBox.getScene().getWindow()).close();
    }

    public void ApplyPress(ActionEvent actionEvent) {
        for(Unit u : units.keySet())
        {
            try {
                clock.addTime(u, units.get(u).getValue());
            } catch (Exception ignore) {
            }
        }
        ((Stage)unitVBox.getScene().getWindow()).close();
    }
}
