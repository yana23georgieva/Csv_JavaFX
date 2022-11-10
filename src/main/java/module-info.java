module com.example.task17 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.opencsv;

    opens com.example.task17 to javafx.fxml;
    exports com.example.task17;
}