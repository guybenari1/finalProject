package AvishayDadon_GuyBenari.Module;

import java.util.ArrayList;
import java.util.Random;

public class Department implements Synchronizable, DynamicWorkable {
    private String name;
    private ArrayList<Role> roles;
    private boolean dynamicWork;
    private boolean sync;

    public Department(String name) {
        this.name = name;
        roles = new ArrayList<Role>();
        dynamicWorkInter();
        synchronizeInter();
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }
    public Double getProductive(){
        double productive =0;
        for (Role role : roles){
            for (int i=0; i<role.getEmployees().size(); i++){
                if (role.getEmployees().get(i).getProductive() != 1) {
                    productive += role.getEmployees().get(i).getProductive();
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

    public boolean equals(Department other) {
        if (!(other instanceof Department))
            return false;
        return name.equals(((Department) other).getName());
    }
}
    //toString
