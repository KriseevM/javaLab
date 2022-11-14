package lab3.task1.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lab3.task1.logic.Clock;
import lab3.task1.logic.IClock;

import java.util.ArrayList;

public class clockPaneController {

    public ArrayList<ClockDeletedListener> deletedListeners = new ArrayList<>();
    @FXML
    private TextField brandNameText;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField priceText;

    @FXML
    private TextField timeText;

    private IClock clock;

    public clockPaneController()
    {}
    public clockPaneController(IClock clock)
    {
        this.clock = clock;
    }

    public void addDeletedListener(ClockDeletedListener l)
    {
        deletedListeners.add(l);
    }
    public void removeDeletedListener(ClockDeletedListener l)
    {
        deletedListeners.remove(l);
    }
    @FXML
    public void initialize(){

    }
    void redraw()
    {
        if(clock != null)
        {
            timeText.setText(clock.getFormattedTime());

        }
    }
    public void addTimeClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("addTimeFrame.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Adding time");
            stage.setScene(new Scene(root, 200, 200));
        } catch (Exception ignored) {}
    }

    public void deleteClick(ActionEvent actionEvent) {
    }
}
