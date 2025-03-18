package com.cristian.jtext.editor;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Arrays;

public class EditorController {

    @FXML
    private TextArea areaText;
    private final EditorModel model;
    private TextFile currentTextFile;

    public EditorController(EditorModel model) {
        this.model = model;
    }

    @FXML
    private void onSave() {
        TextFile textFile = new TextFile(currentTextFile.getFile(), Arrays.asList(areaText.getText().split("\n")));
        model.save(textFile);
    }

    @FXML
    private void onSaveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        var newFile = fileChooser.showSaveDialog(null);
        TextFile textFile = new TextFile(newFile.toPath(), Arrays.asList(areaText.getText().split("\n")));
        model.save(textFile);
    }

    @FXML
    private void onOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            IoResult<TextFile> io = model.open(file.toPath());
            if (io.isOk() && io.hasData()) {
                currentTextFile = io.getData();
                areaText.clear();
                currentTextFile.getContent().forEach(line -> areaText.appendText(line + "\n"));

            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("J Text");
                errorAlert.setHeaderText("Erro!");
                errorAlert.setContentText("Não foi possivel abrir o arquivo " + file.getName());
                errorAlert.show();
            }
        }
    }

    @FXML
    private void onClose() {
        System.exit(0);
    }

    @FXML
    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("J Text");
        alert.setContentText("""
                Um simples editor de texto feito com Java Fx
                contato: <a href="mailto:cristian_santos95@outlook.com">cristian_santos95@outlook.com</a>
                """);
        alert.setHeaderText("Sobre esta aplicação:");
        alert.show();
    }
}
