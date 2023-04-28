module com.huckor.isoparser {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.solab.j8583;

    opens com.huckor.isoparser to javafx.fxml;
    exports com.huckor.isoparser;
}