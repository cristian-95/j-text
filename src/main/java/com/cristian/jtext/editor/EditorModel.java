package com.cristian.jtext.editor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class EditorModel {

    public void close() {
        System.exit(0);
    }

    public void save(TextFile textFile) {
        try {
            Files.write(textFile.getFile(), textFile.getContent(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void saveAs(File newFile, List<String> content) {
        TextFile textFile = new TextFile(newFile.toPath(), content);
        try {
            Files.write(textFile.getFile(), textFile.getContent(), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public IoResult<TextFile> open(Path file) {
        try {
            List<String> lines = Files.readAllLines(file);
            IoResult<TextFile> io = new IoResult<>(new TextFile(file, lines), true);
            return io;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return new IoResult<>(null, false);
        }
    }


    public void delete() {
        System.exit(0);
    }
}
