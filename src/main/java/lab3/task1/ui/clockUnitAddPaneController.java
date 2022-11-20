package lab3.task1.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import lab3.task1.logic.Unit;

import java.util.function.UnaryOperator;

public class clockUnitAddPaneController {
    public TextField valueField;
    public Label unitNameLabel;

    private Unit unit;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        redraw();
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
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String input = change.getText();
            if (input.matches("[0-9]*")) {
                return change;
            }
            return null;
        };
        valueField.setTextFormatter(new TextFormatter<>(integerFilter));
        valueField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                value = Integer.parseInt(t1);
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
