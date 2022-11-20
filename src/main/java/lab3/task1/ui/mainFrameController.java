package lab3.task1.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lab3.task1.logic.ClockStore;
import lab3.task1.logic.IClock;

import java.io.IOException;

public class mainFrameController {

    public TextField expensiveClockTB;
    public TextField commonClockTB;
    public ListView<String> brandsLB;
    public Accordion clocksAccordion;
    private ClockStore store;

    public mainFrameController()
    {
        store = new ClockStore();
    }

    private void redraw()
    {
        clocksAccordion.getPanes().clear();
        for(IClock c : store.getClocks())
        {
            try {
                clockPaneController controller = new clockPaneController(c);
                controller.addDeletedListener(new ClockDeletedListener() {
                    @Override
                    public void ClockDeleted(IClock clock) {
                        store.remove(clock);
                        redraw();
                    }
                });
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("clockPane.fxml"));
                loader.setController(controller);
                TitledPane p = loader.load();
                clocksAccordion.getPanes().add(p);
            }
            catch(Exception ignored){
                throw new RuntimeException(ignored);
            }
        }
        commonClockTB.setText(store.getMostCommonBrandName());
        brandsLB.getItems().clear();
        brandsLB.getItems().setAll(store.getSortedBrandNamesArray());
    }

    public void ClockAddClick(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("addClockFrame.fxml"));
        try {
            Stage s = new Stage();
            s.setScene(new Scene(loader.load()));
            ((addClockFrameController)loader.getController()).addClockAddedListener(new ClockAddedListener() {
                @Override
                public void ClockAdded(IClock clock) {
                    store.add(clock);
                }
            });
            s.showAndWait();
            redraw();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
