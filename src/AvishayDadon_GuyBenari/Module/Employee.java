package AvishayDadon_GuyBenari.Module;

import java.util.Random;

public class Employee implements Synchronizable, DynamicWorkable {
    //public enum Preference {EARLY_START, LATE_START, NO_CHANGE, STAY_HOME}
    public enum SalaryType {GLOBAL, HOURS, HOURS_WITH_BONUS}
    private String name;
    private Role role;
    private syncType syncType;
    private SalaryType salaryType;
    private int salaryHours;
    private double salaryBase;
    private double hours;
    //private boolean sync;
    //private boolean dWork;

    public Employee(String name, Role job, syncType syncType, SalaryType salaryType, double salaryBase, int salaryHours) {
        this.name = name;
        this.role = job;
        this.syncType = syncType;
        setSalaryBase(salaryType, salaryBase);
        setSalaryHours(salaryType, salaryHours);
        setHours(syncType);
        //dynamicWork(dWork);
        synchronize(syncType);
    }

    private void setHours(syncType syncType) {
        switch (syncType){
            case LATE_START:{
                this.hours=1;
            }
            case EARLY_START:{
                this.hours=1;
            }
            case STAY_HOME:{
                this.hours=8;
            }
            default:{
                this.hours=0;
            }
        }
    }

    public void setSalaryBase(SalaryType salaryType, double salaryBase) {
        Random random = new Random();
        double present = random.nextInt(100) / 100.0;
        if (salaryType == SalaryType.HOURS_WITH_BONUS) {
            this.salaryBase = (salaryBase + (present * salaryBase));
        } else {
            this.salaryBase = salaryBase;
        }
    }

    public void setSalaryHours(SalaryType salaryType, int salaryHours) {
        if (salaryType == SalaryType.GLOBAL) {
            this.salaryHours = 160;
        } else {
            this.salaryHours = salaryHours;
        }
    }

    /*public Double getProductive() {
        if (!role.getdWork()) {
            if (syncType == syncType.NO_CHANGE) {
                return hours * 0.2;
            }
        } else {
            if (role.getSyncType()) {
                if (syncType.equals(role.getRoleDepartment().getSyncType())) {
                    return hours * 0.2;
                } else {
                    return hours * (-0.2);
                }
            }
        }
        return hours * 0.2;
    }*/

    public String getName() {
        return name;
    }

    public syncType getSyncType() {
        return syncType;
    }

    //public boolean getSync() {
     //   return sync;
    //}

    //public boolean getdWork() {
     //   return dWork;
   // }

    @Override
    public void dynamicWork(boolean dWork) {
        dWork = role.getdWork();
    }

    @Override
    //TO add exep
    public void synchronize(syncType syncType){
        if (role.getSyncType() == syncType.NO_SYNC){
            this.syncType = syncType;
        }
        else{
            if (syncType != role.getSyncType()){
                System.out.println("ERROR: not equal");
            }
            else {
                this.syncType = role.getSyncType();
            }
        }
    }

    public boolean equals(Employee other) {
        if (!(other instanceof Employee))
            return false;
        return name.equals(((Employee) other).getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", syncType=" + syncType +
                ", salaryType=" + salaryType +
                ", salaryHours=" + salaryHours +
                ", salaryBase=" + salaryBase +
                ", hours=" + hours +
                //", sync=" + sync +
                //", dWork=" + dWork +
                '}';
    }
}
