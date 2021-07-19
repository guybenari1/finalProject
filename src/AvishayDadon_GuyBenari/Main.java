package AvishayDadon_GuyBenari;
import javax.swing.*;
import java.util.*;

import AvishayDadon_GuyBenari.Module.*;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


public class Main /*extends Application*/ {

    public static void main(String[] args) {
        Company company = new Company("firstCompany");
        Department department1 = new Department("firstDepartment", company);
        Department department2 = new Department("secondDepartment", company);
        Role role1 = new Role("firstRole", department1);
        Role role2 = new Role("secondRole", department1);
        Role role3 = new Role("thirdRole", department2);
        Role role4 = new Role("fourthRole", department2);
        Employee employee1 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee2 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee3 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee4 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee5 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee6 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee7 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee8 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee9 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee10 = new Employee("firstEmployee",role1, Preference.LATE_START);
        Employee employee11 = new Employee("firstEmployee",role1, Preference.EARLY_START);

        System.out.println(department1.getDynamicWork());
        System.out.println(department1.getSync());
        System.out.println(role1.getDynamicWork());
        System.out.println(role1.getSync());
        System.out.println(employee2.getProductive());
        System.out.println(employee11.getProductive());
        System.out.println(department1.getProductive());

        //launch(args);
    }

    public void start(Stage primaryStage) {

    }
}
