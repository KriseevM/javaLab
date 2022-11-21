package lab3.task1.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lab3.task1.logic.IClock;
import lab3.task1.util.DoubleTextFilter;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.reflections.scanners.Scanners.SubTypes;

public class addClockFrameController {
    public TextField timeText;
    public TextField priceText;
    public TextField brandText;
    IClock clock;
    public ChoiceBox<Class> clockTypesDropdown;
    private ArrayList<ClockAddedListener> addedListeners = new ArrayList<>();

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
        } catch (Exception ignored) {
        }
    }

    public void addClockAddedListener(ClockAddedListener l)
    {
        addedListeners.add(l);
    }
    public void removeClockAddedListener(ClockAddedListener l)
    {
        addedListeners.remove(l);
    }
    private void invokeClockAddedEvent() { addedListeners.forEach(p -> p.ClockAdded(clock));}
    public void addToStoreClick(ActionEvent actionEvent) {
        if(clock.getBrandName().equals("") || clock.getPrice() == 0.0)
        {
            return;
        }
        invokeClockAddedEvent();
        ((Stage)timeText.getScene().getWindow()).close();
    }
    @FXML
    public void initialize()
    {
        Reflections ref = new Reflections("lab3.task1.logic");
        Set<Class<?>> clockTypes =  ref.get(SubTypes.of(IClock.class).asClass());
        Set<Class<?>> filtered = new HashSet<>();
        clockTypes.forEach(p -> {
            if(!Modifier.isAbstract(p.getModifiers())) {
                filtered.add(p);
            }
        });
        clockTypesDropdown.setItems(FXCollections.observableArrayList(filtered));
        clockTypesDropdown.getSelectionModel().select(0);
        try {
            clock = (IClock) clockTypesDropdown.getSelectionModel().getSelectedItem().getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        clockTypesDropdown.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Class>() {
            @Override
            public void changed(ObservableValue<? extends Class> observableValue, Class aClass, Class t1) {
                if(clock.getClass() != t1)
                {
                    try {
                        clock = (IClock) t1.getConstructor().newInstance();
                    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                             InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                    redraw();
                }
            }
        });
        priceText.textProperty().addListener(new DoubleTextFilter(priceText));
        priceText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                clock.setPrice(Double.parseDouble(t1));
            }
        });
        brandText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                clock.setBrandName(t1);
                redraw();
            }
        });
        redraw();
    }
    void redraw()
    {
        timeText.setText(clock.getFormattedTime());
        priceText.setText(Double.toString(clock.getPrice()));
        brandText.setText(clock.getBrandName());
    }
}
