package AvishayDadon_GuyBenari.Module;

import java.util.Random;

public class Employee implements Synchronizable, DynamicWorkable {
    Random random = new Random();
    private final double PRESENT = random.nextInt(100) / 100.0;
    public enum SalaryType {GLOBAL, HOURS, GLOBAL_WITH_BONUS}
    private final double SALARY_BASE = 10.0;
    private final double MONEY_PER_HOUR = 20.0;
    private SalaryType salaryType;
    private String name;
    private Role role;
    private Preference pref;
    private int hours;
    private boolean sync;
    private boolean dynamicWork;

    public Employee(String name, Role role, Preference pref) {
        this.name = name;
        this.role = role;
        this.pref = pref;
        setSalaryType();
        setHours(pref);
        dynamicWorkInter();
        synchronizeInter();
        role.addEmployee(this);
    }

    private void setHours(Preference pref) {
        switch (pref) {
            case LATE_START, EARLY_START -> {
                this.hours = 1;
            }
            case STAY_HOME -> {
                this.hours = 8;
            }
            case NO_CHANGE -> {
                this.hours = 0;
            }
        }
    }

    public void setSalaryType (){
        Random random = new Random();
        int num = random.nextInt(3)+1;
        switch (num){
            case 1 -> {
                this.salaryType = SalaryType.GLOBAL;
            }
            case 2 -> {
                this.salaryType = SalaryType.HOURS;
            }
            case 3 -> {
                this.salaryType = SalaryType.GLOBAL_WITH_BONUS;
            }
        }
    }

    public double getSalaryBase() {
        if (this.salaryType == SalaryType.GLOBAL_WITH_BONUS)
            return (SALARY_BASE + (PRESENT * SALARY_BASE));
        else
            return SALARY_BASE;
    }

    public double getMoneyPerMonth(){
        return MONEY_PER_HOUR*getSalaryHours();
    }

    public Preference getPref() {
        return pref;
    }

    public int getSalaryHours() {
        if (this.salaryType != SalaryType.HOURS)
            return 160;
        else
            return 100;
    }
    //FIX SOUT
    public void getTotalSalary(){
        System.out.printf("This employee costs the company %d per month \n", getSalaryHours()*getSalaryBase());
        System.out.printf("Before the changes this employee made the company: %d per month \n", getMoneyPerMonth());
        System.out.printf("After the changes this employee made the company: %d per month \n", getMoneyPerMonth()*getProductive());
    }

    public Double getProductive() {
        double productive = 1;
        if (role.getDynamicWork()){
            if (role.getSync()){
                if (pref == role.getEmployees().get(0).getPref()){
                    if (pref == Preference.STAY_HOME){
                        productive = 0.1;
                    }
                    else {
                        productive = 0.2;
                    }
                }
                else {
                    productive = (-0.2);
                }
            }
            else {
                if (pref == Preference.STAY_HOME) {
                    productive = 0.1;
                }
                else {
                    productive = 0.2;
                }
            }
        }
        return productive;
    }

    public double getProfit(){
        return hours*getProductive();
    }

    public String getName() {
        return name;
    }

    public boolean getSync() {
        return sync;
    }

    public boolean getDynamicWork() {
        return dynamicWork;
    }

    @Override
    public void dynamicWorkInter() {
        this.dynamicWork = role.getDynamicWork();
    }

    @Override
    public void synchronizeInter(){
        this.sync = role.getSync();
    }

    public boolean equals(Employee other) {
        if (!(other instanceof Employee))
            return false;
        return name.equals(((Employee) other).getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "random=" + random +
                ", PRESENT=" + PRESENT +
                ", SALARY_BASE=" + SALARY_BASE +
                ", MONEY_PER_HOUR=" + MONEY_PER_HOUR +
                ", salaryType=" + salaryType +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", pref=" + pref +
                ", hours=" + hours +
                ", sync=" + sync +
                ", dynamicWork=" + dynamicWork +
                '}';
    }
    //toString
}
