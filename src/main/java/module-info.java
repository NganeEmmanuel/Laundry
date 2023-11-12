module com.laundry.laundry {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires fontawesomefx;
    requires jakarta.annotation;
    requires jakarta.persistence;

    opens com.laundry.laundry to javafx.fxml;
    exports com.laundry.laundry;
    exports com.laundry.laundry.controller;
    opens com.laundry.laundry.controller to javafx.fxml;
}