package lab3.task1.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextInputControl;

import java.util.Objects;

public class DoubleTextFilter implements ChangeListener<String> {
    private TextInputControl textBox;

    public DoubleTextFilter(TextInputControl textBox) {
        this.textBox = textBox;
    }


    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        try {
            Double.parseDouble(t1);
            if (s.equals("0")) {
                textBox.setText(t1.substring(1));
            }
        } catch (Exception ignored) {
            if (Objects.equals(t1, "")) {
                s = "0";
            }
            textBox.setText(s);
        }
    }
}
