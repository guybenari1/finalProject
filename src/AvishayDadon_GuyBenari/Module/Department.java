package AvishayDadon_GuyBenari.Module;

import java.util.ArrayList;
import java.util.Random;

public class Department implements Synchronizable, DynamicWorkable {
    private String name;
    private ArrayList<Role> roles;
    private boolean dWork;
    private syncType syncType;

    public Department(String name, syncType syncType, boolean dWork) {
        this.name = name;
        this.dWork= dWork;
        roles = new ArrayList<Role>();
        dynamicWork(dWork);
        synchronize(syncType);
    }
    public syncType getSyncType() {
        return syncType;
    }
    public Double getProductive(){
        double productive=0;
        for (Role role : roles) {
            productive += role.getProductive();
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
    //public boolean getSync() {
       // return sync;
  //  }
    public boolean getdWork() {
        return dWork;
    }
    @Override
    public void dynamicWork(boolean dWork) {
        Random rand = new Random();
        dWork = rand.nextBoolean();
    }
    @Override
    public void synchronize(syncType syncType) {
        this.syncType = syncType;
    }
    public boolean equals(Department other) {
        if (!(other instanceof Department))
            return false;
        return name.equals(((Department)other).getName());
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", roles=" + roles +
                //", sync=" + sync +
                ", dWork=" + dWork +
                ", syncType=" + syncType +
                '}';
    }
}
