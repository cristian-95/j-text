module com.cristian.jtext {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    exports com.cristian.jtext.editor;

    opens com.cristian.jtext.editor to javafx.fxml;
}