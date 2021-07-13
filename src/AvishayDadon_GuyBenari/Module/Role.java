package AvishayDadon_GuyBenari.Module;

import java.util.ArrayList;

public class Role implements Synchronizable, DynamicWorkable {
    private String name;
    private Department department;
    private ArrayList<Employee> employees;
    private boolean dWork;
    private syncType syncType;

    public Role(String name, Department department, syncType syncType, boolean dWork) {
        this.name = name;
        this.department = department;
        this.dWork = dWork;
        employees = new ArrayList<Employee>();
        dynamicWork(dWork);
        synchronize(syncType);
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
        return department;
    }
   // public boolean getSync() {
   //     return sync;
   // }
    public boolean getdWork() {
        return dWork;
    }
    @Override
    public void dynamicWork(boolean dWork) {
        dWork = department.getdWork();
    }
    @Override
    public void synchronize(syncType syncType) {
        if (department.getSyncType() == syncType.NO_SYNC){
            this.syncType = syncType;
        }
        else{
            if (syncType != department.getSyncType()){
                System.out.println("ERROR: not equal");
            }
            else {
                this.syncType = department.getSyncType();
            }
        }
    }
    public boolean equals(Role other) {
        if (!(other instanceof Role))
            return false;
        Role temp = other;
        if (!(name.equals(temp.getName()) || department.equals(temp.getRoleDepartment())))
            return false;
        return true;
    }
    public syncType getSyncType() {
        return syncType;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", employees=" + employees +
                //", sync=" + sync +
                ", dWork=" + dWork +
                ", syncType=" + syncType +
                '}';
    }
}
