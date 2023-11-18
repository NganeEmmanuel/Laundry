package com.laundry.laundry;

import com.laundry.laundry.dao.persistentDao.EmployeeDao;
import com.laundry.laundry.model.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Optional<Employee> employees;

        EmployeeDao employeeDao = new EmployeeDao();
        employees = employeeDao.findById(1);
        Employee emp = employees.get();
        emp.setCity("Buea");
        emp.setEmail("test@gmail.com");
        emp = employeeDao.update(emp);
        System.out.println(emp.toString());


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