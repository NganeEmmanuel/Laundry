package com.laundry.laundry;

import com.laundry.laundry.dao.EmployeeDao;
import com.laundry.laundry.dao.UserDao;
import com.laundry.laundry.model.Employee;
import com.laundry.laundry.model.User;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Employee user = new Employee();
        user.setName("Ngane Emmanuel");
        user.setCity("test123$");

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.add(user);
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 779, 604);
        stage.setTitle("Laundry Management System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}