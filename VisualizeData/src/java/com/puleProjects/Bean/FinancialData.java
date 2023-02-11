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
public class FinancialData {
     private String month;
  private double income;
  private double costs;
  
  public String getMonth() {
    return month;
  }
  
  public void setMonth(String month) {
    this.month = month;
  }
  
  public double getIncome() {
    return income;
  }
  
  public void setIncome(double income) {
    this.income = income;
  }
  
  public double getCosts() {
    return costs;
  }
  
  public void setCosts(double costs) {
    this.costs = costs;
  }

    public FinancialData() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FinancialData{month=").append(month);
        sb.append(", income=").append(income);
        sb.append(", costs=").append(costs);
        sb.append('}');
        return sb.toString();
    }
    
    
}
