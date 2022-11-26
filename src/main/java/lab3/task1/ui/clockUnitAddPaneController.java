package lab3.task1.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lab3.task1.logic.Unit;

import java.util.Objects;

public class clockUnitAddPaneController {
    public TextField valueField;
    public Label unitNameLabel;

    private Unit unit;

    public int getValue() {
        return value;
    }

    public void setValueAndRedraw(int value) {
        setValue(value);
        redraw();
    }

    private void setValue(int value) {
        this.value = value;
    }

    private int value = 0;

    public clockUnitAddPaneController()
    {}

    public clockUnitAddPaneController(Unit unit)
    {
        this.unit = unit;
    }
    @FXML
    public void initialize()
    {
        unitNameLabel.setText(unit.toString());
        valueField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try {
                    int val = Integer.parseInt(t1);
                    if (s.equals("0")) {
                        valueField.setText(t1.substring(1));
                        setValue(val);
                    }
                } catch (Exception ignored) {
                    if (Objects.equals(t1, "")) {
                        s = "0";
                    }
                    valueField.setText(s);
                    setValue(Integer.parseInt(s));
                }
            }
        });
        this.valueField.setText(Integer.toString(value));
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
        redraw();
    }

    private void redraw() {
        if (unitNameLabel != null)
        {
            unitNameLabel.setText(unit.toString());
            this.valueField.setText(Integer.toString(value));
        }
    }


}
