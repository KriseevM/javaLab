package lab3.task1.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import lab3.task1.logic.IClock;

import java.util.ArrayList;

public class clockPaneController {
    public TitledPane parentPane;
    public ArrayList<ClockDeletedListener> deletedListeners = new ArrayList<>();
    public TextField brandNameText;

    public TextField priceText;

    public TextField timeText;

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
    private void invokeDeletedEvent() { deletedListeners.forEach(p -> p.ClockDeleted(clock));}
    @FXML
    public void initialize(){
        redraw();
    }
    void redraw()
    {
        if(clock != null)
        {
            timeText.setText(clock.getFormattedTime());
            brandNameText.setText(clock.getBrandName());
            priceText.setText(Double.toString(clock.getPrice()));
            parentPane.setText(String.format("%s clock", clock.getBrandName()));
        }

    }
    public void addTimeClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("addTimeFrame.fxml"));
            loader.setController(new addTimeFrameController(clock));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adding time");
            stage.setScene(new Scene(root, 200, 200));
            stage.showAndWait();
            redraw();
        } catch (Exception ignored) {}
    }

    public void deleteClick(ActionEvent actionEvent) {
        invokeDeletedEvent();
    }
}
