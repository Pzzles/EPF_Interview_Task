/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleProjects.dao;

import com.puleProjects.Bean.Customer;
import com.puleProjects.Bean.FinancialData;
import com.puleProjects.utils.ConnectionDB;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PULE
 */
public class CustomerModel extends DAOImplementation {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public boolean addCustomer(Customer customer, List<FinancialData> financialData) {
        boolean result = false;

        try {
            con = ConnectionDB.getInstance();
            if (con != null) {

                ps = con.prepareStatement("INSERT INTO EPFinterview.customer("
                        + "Name,"
                        + "Surname,"
                        + "DateOfBirth,"
                        + "Month,"
                        + "Income,"
                        + "Expenses"
                        + ") VALUES (?,?,?,?,?,?)");

                ps.setString(1, customer.getfName());
                ps.setString(2, customer.getLName());
                ps.setString(3, customer.getDOB());
                for (FinancialData data : financialData) {
                    ps.setString(4, data.getMonth());
                    ps.setDouble(5, data.getIncome());
                    ps.setDouble(6, data.getCosts());
                    result = ps.executeUpdate() > 0;
                }

            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException sqlex) {
                    System.out.println("Error! " + sqlex.getMessage());
                }
            }
            con = null;
        }

        return result;
    }

    @Override
    public List<Customer> viewCustomer() {
        con = ConnectionDB.getInstance();
        List<Customer> data = new ArrayList<>();

        try {
            if (con != null) {

                ps = con.prepareStatement("SELECT name, surname, Month, Income, Expenses FROM Customer");
                rs = ps.executeQuery();

                while (rs.next()) {
                    Customer customer = new Customer();
//                    customer.setId(rs.getInt("id"));
                    customer.setfName(rs.getString("name"));
                    customer.setLName(rs.getString("surname"));
//                    customer.setDOB(rs.getString("dateOfBirth"));
                    customer.setMonth(rs.getString("Month"));
                    customer.setIncome(rs.getDouble("Income"));
                    customer.setExpenses(rs.getDouble("Expenses"));
                    data.add(customer);
                    
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }

        return data;
    }

}
