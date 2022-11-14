package lab3.task1.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import lab3.task1.logic.Clock;
import lab3.task1.logic.ClockStore;
import lab3.task1.logic.IClock;

public class mainFrameController implements ClockDeletedListener {

    public TextField expensiveClockTB;
    public TextField commonClockTB;
    public VBox clocksVBox;
    public ListView brandsLB;
    private ClockStore store;

    public mainFrameController()
    {
        store = new ClockStore();
    }

    @Override
    public void ClockDeleted(Clock clock) {
        store.remove(clock);
        redraw();
    }

    private void redraw()
    {
        clocksVBox.getChildren().clear();
        for(IClock c : store.getClocks())
        {
            try {
                clockPaneController controller = new clockPaneController(c);
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("clockPane.fxml"));
                loader.setController(controller);
                TitledPane p = loader.load();
                clocksVBox.getChildren().add(p);
            }
            catch(Exception ignored){}
        }
    }

    public void ClockAddClick(ActionEvent actionEvent) {
    }
}
