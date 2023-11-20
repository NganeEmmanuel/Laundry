package com.laundry.laundry.controller;

import com.laundry.laundry.helper.session.sessionClass.EmployeeSession;
import com.laundry.laundry.model.Employee;
import com.laundry.laundry.service.serviceClass.LoginService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Button loginBtn;

    @FXML
    private FontAwesomeIconView loginSpinner;

    @FXML
    private PasswordField password;

    @FXML
    private TextField password2;

    @FXML
    private FontAwesomeIconView showPassword;

    @FXML
    private TextField username;

    @FXML
    private Label warningMsg;

    private LoginService loginService = new LoginService();

//    String password = "1234";
//    String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
//// $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6
//    ...
//    BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
    // result.verified == true


    @FXML
    void login(MouseEvent event) {
        loginSpinner.setVisible(true);
        loginBtn.setDisable(true);
        if(!username.getText().isBlank() &&
                !(password.isVisible()?password.getText() : password2.getText()).isBlank()
        ){
            Employee employee = loginService.login(username.getText(), password.getText());
            if(employee != null){
                EmployeeSession employeeSession = EmployeeSession.getInstace();
                System.out.println(employeeSession.getEmployee());
                //todo code for successful logging
                //todo also figure out the activities logging mechanism
            }else{
                warning("Invalid user credentials. Please try again!!");
            }
        }else{
            warning("All fields must be filled. Try again!!");
        }
    }

    private void warning(String message) {
        warningMsg.setText(message);
        warningMsg.setVisible(true);
        FadeTransition fadOutMsg = new FadeTransition(Duration.seconds(10), warningMsg);
        fadOutMsg.setFromValue(1);
        fadOutMsg.setToValue(0);
        fadOutMsg.setCycleCount(1);
        loginSpinner.setVisible(false);
        loginBtn.setDisable(false);
        fadOutMsg.play();
    }

    @FXML
    void showPassword(MouseEvent event) {
        if(password.isVisible()){
            password2.setText(password.getText());
            password2.setVisible(true);
            password.setVisible(false);
        }else{
            password.setText(password2.getText());
            password.setVisible(true);
            password2.setVisible(false);
        }
    }


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