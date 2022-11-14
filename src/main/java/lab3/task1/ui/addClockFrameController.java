package lab3.task1.ui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import lab3.task1.logic.IClock;
import org.reflections.Reflections;

import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

public class addClockFrameController {
    public ChoiceBox<String> clockTypesDropdown;

    public void addTimeClick(ActionEvent actionEvent) {
    }

    public void deleteClick(ActionEvent actionEvent) {
    }
    @FXML
    public void initialize()
    {
        Reflections ref = new Reflections("lab3.task1.logic");
        Set<String> clockTypes =  ref.get(SubTypes.of(IClock.class).asString());
        clockTypesDropdown.setItems(FXCollections.observableArrayList(clockTypes));

    }
}
