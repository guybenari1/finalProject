package AvishayDadon_GuyBenari.Module;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Department> allDepo;
    private ArrayList<Employee> allEmployees;

    public Company(String name) {
        this.name = name;
        allDepo = new ArrayList<Department>();
        allEmployees = new ArrayList<Employee>();
    }
    public String getName() {
        return name;
    }
    public boolean addDepo(Department newDepo) {
        if (allDepo.contains(newDepo))
            return false;
        allDepo.add(newDepo);
        return true;
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

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", allDepo=" + allDepo +
                ", allEmployees=" + allEmployees +
                '}';
    }
}

