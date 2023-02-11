/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleProject.tests;

import com.puleProjects.Bean.Customer;
import com.puleProjects.dao.CustomerModel;
import com.puleProjects.dao.DAO;
import java.util.List;

/**
 *
 * @author PULE
 */
public class Test {
    public static void main(String[] args) {
        new Test().run();
    }
    
    public void run(){
                       DAO customerDao = new CustomerModel();
                        List<Customer> dataList = customerDao.viewCustomer();

                        for (Customer customerData : dataList) {
                            System.out.println(customerData.getMonth());
                                }
    }
}
