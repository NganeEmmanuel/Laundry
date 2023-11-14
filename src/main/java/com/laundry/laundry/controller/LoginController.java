package com.laundry.laundry.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        loadSplashScreen();
    }

//    private void loadSplashScreen() {
//        try {
//            //Load splash screen view FXML
//            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("./startLoad-view.fxml")));
//            //Add it to root container (Can be StackPane, AnchorPane etc)
//            root.getChildren().setAll(pane);
//
//            //Load splash screen with fade in effect
//            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
//            fadeIn.setFromValue(0);
//            fadeIn.setToValue(1);
//            fadeIn.setCycleCount(1);
//
//            //Finish splash with fade out effect
////            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
////            fadeOut.setFromValue(1);
////            fadeOut.setToValue(0);
////            fadeOut.setCycleCount(1);
//
//            fadeIn.play();
//
////            //After fade in, start fade out
////            fadeIn.setOnFinished((e) -> {
////                fadeOut.play();
////            });
////
////            //After fade out, load actual content
////            fadeOut.setOnFinished((e) -> {
////                try {
////                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/login.fxml")));
////                    root.getChildren().setAll(parentContent);
////                } catch (IOException ex) {
////                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            });
//        } catch (IOException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}