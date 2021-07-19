package AvishayDadon_GuyBenari.Module;

import java.util.ArrayList;
import java.util.Random;

public class Role implements Synchronizable, DynamicWorkable {
    private String name;
    private Department department;
    private ArrayList<Employee> employees;
    private boolean dynamicWork;
    private boolean sync;

    public Role(String name, Department department) {
        this.name = name;
        this.department = department;
        employees = new ArrayList<Employee>();
        dynamicWorkInter();
        synchronizeInter();
        department.addRole(this);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public String getName() {
        return name;
    }
    public Department getRoleDepartment() {
        return department;
    }

    public boolean getSync() {
        return sync;
    }

    public boolean getDynamicWork() {
        return dynamicWork;
    }
    public boolean addEmployee(Employee newEmployee) {
        if (employees.contains(newEmployee))
            return false;
        employees.add(newEmployee);
        return true;
    }
    @Override
    public void dynamicWorkInter() {
        Random rand = new Random();
        this.dynamicWork = (department.getDynamicWork()) && (rand.nextBoolean());
    }
    @Override
    public void synchronizeInter() {
        this.sync = department.getSync();
    }
    public boolean equals(Role other) {
        if (!(other instanceof Role))
            return false;
        Role temp = other;
        if (!(name.equals(temp.getName()) || department.equals(temp.getRoleDepartment())))
            return false;
        return true;
    }
    //toString

}
