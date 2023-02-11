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
public abstract class DAOImplementation implements DAO{

    @Override
    public boolean addCustomer(Customer customer, List<FinancialData> financialData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Customer> viewCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
