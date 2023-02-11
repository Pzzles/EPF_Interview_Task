/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleProjects.dao;

import com.puleProjects.Bean.Customer;
import com.puleProjects.Bean.FinancialData;
import java.util.List;

/**
 *
 * @author PULE
 */
public interface DAO {

    public boolean addCustomer(Customer customer, List<FinancialData> financialData);


    public List<Customer> viewCustomer();
}
