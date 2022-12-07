module javaLab3 {
    requires com.google.gson;
    requires jakarta.persistence;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.hibernate.orm.core;
    requires org.reflections;
    requires java.naming;
    exports lab3.task1.util;
    exports lab3.task1.ui;
    exports lab3.task1.logic;
    opens lab3.task1.logic;

}