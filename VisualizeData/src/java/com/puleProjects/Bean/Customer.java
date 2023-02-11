/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleProjects.Bean;

/**
 *
 * @author PULE
 */
public class Customer {

    private int id;
    private String fName;
    private String LName;
    private String DOB;
    private String Month;
    private double Income;
    private double Expenses;

    public Customer() {
    }

    public Customer(int id, String fName, String LName, String DOB, String Month, double Income, double Expenses) {
        this.id = id;
        this.fName = fName;
        this.LName = LName;
        this.DOB = DOB;
        this.Month = Month;
        this.Income = Income;
        this.Expenses = Expenses;
    }

    public Customer(String fName, String LName, String DOB) {
        this.fName = fName;
        this.LName = LName;
        this.DOB = DOB;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public double getIncome() {
        return Income;
    }

    public void setIncome(double Income) {
        this.Income = Income;
    }

    public double getExpenses() {
        return Expenses;
    }

    public void setExpenses(double Expenses) {
        this.Expenses = Expenses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer{id=").append(id);
        sb.append(", fName=").append(fName);
        sb.append(", LName=").append(LName);
        sb.append(", DOB=").append(DOB);
        sb.append(", Month=").append(Month);
        sb.append(", Income=").append(Income);
        sb.append(", Expenses=").append(Expenses);
        sb.append('}');
        return sb.toString();
    }

  


    
}
