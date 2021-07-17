package AvishayDadon_GuyBenari.Module;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Department> allDepartments;
    private ArrayList<Employee> allEmployees;

    public Company(String name) {
        this.name = name;
        allDepartments = new ArrayList<Department>();
        allEmployees = new ArrayList<Employee>();
    }
    public String getName() {
        return name;
    }
    public boolean addDepartment(Department newDepartment) {
        if (allDepartments.contains(newDepartment))
            return false;
        allDepartments.add(newDepartment);
        return true;
    }
    public Double getProductive(){
        double productive =0;
        for (Department department : allDepartments){
            productive+=department.getProductive();
        }
        return productive;
    }
    public boolean addEmployee(Employee newEmployee) {
        if (allEmployees.contains(newEmployee))
            return false;
        allEmployees.add(newEmployee);
        return true;
    }
    public boolean equals(Company other) {
        if (!(other instanceof Company))
            return false;
        return name.equals(((Company)other).getName());
    }

    //toString

}

