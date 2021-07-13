package AvishayDadon_GuyBenari.Module;

import java.util.ArrayList;

public class Role implements Synchronizable, DynamicWorkable {
    private String name;
    private Department depo;
    private ArrayList<Employee> employees;
    private boolean sync;
    private boolean dWork;
    public enum syncType { EARLY_START, LATE_START, NO_CHANGE, STAY_HOME }
    private syncType syncType;

    public Role(String name, Department depo, syncType syncType) {
        this.name = name;
        this.depo = depo;
        this.syncType = syncType;
        employees = new ArrayList<Employee>();
        dynamicWork(dWork);
        synchronize(sync);
    }
    public Double getProductive(){
        double productive=0;
        for (Employee employee : employees) {
            productive += employee.getProductive();
        }
        return productive;
    }
    public String getName() {
        return name;
    }
    public Department getRoleDepartment() {
        return depo;
    }
    public boolean getSync() {
        return sync;
    }
    public boolean getdWork() {
        return dWork;
    }
    @Override
    public void dynamicWork(boolean dWork) {
        dWork = depo.getdWork();
    }
    @Override
    public void synchronize(boolean sync) {
        sync = depo.getSync();
    }
    public boolean equals(Role other) {
        if (!(other instanceof Role))
            return false;
        Role temp = other;
        if (!(name.equals(temp.getName()) || depo.equals(temp.getRoleDepartment())))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", depo=" + depo +
                ", employees=" + employees +
                ", sync=" + sync +
                ", dWork=" + dWork +
                ", syncType=" + syncType +
                '}';
    }
}
