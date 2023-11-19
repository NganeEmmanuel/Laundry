package com.laundry.laundry;

import com.laundry.laundry.dao.persistentDao.EmployeeDao;
import com.laundry.laundry.helper.UserStatus;
import com.laundry.laundry.model.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Optional<List<Employee>> employees;
        Date date = new Date();
        EmployeeDao employeeDao = new EmployeeDao();
        employees = employeeDao.findBy("status", UserStatus.ACTIVE, 0);
        System.out.println(employees.toString());


        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
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