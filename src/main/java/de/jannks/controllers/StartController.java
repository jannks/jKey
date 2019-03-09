package de.jannks.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.security.SecureRandom;
import java.util.Random;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    private static final char[] ASCII =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}|;:,<.>/?"
            .toCharArray();

    @FXML private Button button64;
    @FXML private Button button128;
    @FXML private Button button256;
    @FXML private Button button512;
    @FXML private Button button1024;
    @FXML private Button button2048;
    @FXML private Button button4096;

    @FXML private TextArea textKey;

    private final Random random = new SecureRandom();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        button64.setOnAction( event -> setKey(8));
        button128.setOnAction( event -> setKey(16));
        button256.setOnAction( event -> setKey(32));
        button512.setOnAction( event -> setKey(64));
        button1024.setOnAction( event -> setKey(128));
        button2048.setOnAction( event -> setKey(256));
        button4096.setOnAction( event -> setKey(512));

        textKey.setWrapText(true);
    }

    private void setKey(int length) {
        final char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = ASCII[random.nextInt(ASCII.length)];
        }
        textKey.setText(new String(chars));
    }

}
