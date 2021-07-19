package AvishayDadon_GuyBenari.Module;

import java.util.ArrayList;
import java.util.Random;

public class Department implements Synchronizable, DynamicWorkable {
    private String name;
    private Company company;
    private ArrayList<Role> roles;
    private boolean dynamicWork;
    private boolean sync;

    public Department(String name, Company company) {
        this.name = name;
        this.company=company;
        roles = new ArrayList<Role>();
        dynamicWorkInter();
        synchronizeInter();
        company.addDepartment(this);
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }
    public Double getProductive(){
        double productive =0;
        for (Role role : roles){
            for (int i=0; i<role.getEmployees().size(); i++){
                if (role.getEmployees().get(i).getProductive() != 1) {
                    productive += role.getEmployees().get(i).getProfit();
                }
            }
        }
        return productive;
    }

    public String getName() {
        return name;
    }

    public boolean addRole(Role newRole) {
        if (roles.contains(newRole))
            return false;
        roles.add(newRole);
        return true;
    }

    public boolean getSync() {
        return sync;
    }

    public boolean getDynamicWork() {
        return dynamicWork;
    }

    @Override
    public void dynamicWorkInter() {
        Random rand = new Random();
        this.dynamicWork = rand.nextBoolean();
    }

    @Override
    public void synchronizeInter() {
        Random rand = new Random();
        this.sync = rand.nextBoolean();
    }

    //fix with company
    public boolean equals(Department other) {
        if (!(other instanceof Department))
            return false;
        return name.equals(((Department) other).getName());
    }
}
    //toString
