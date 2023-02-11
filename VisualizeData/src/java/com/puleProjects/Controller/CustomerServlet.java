/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleProjects.Controller;

import com.puleProjects.Bean.Customer;
import com.puleProjects.Bean.FinancialData;
import com.puleProjects.dao.CustomerModel;
import com.puleProjects.dao.DAO;
import com.puleProjects.dao.DAOImplementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author PULE
 */

@MultipartConfig
@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        Part filePart = request.getPart("file");
 if (filePart == null) {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      out.println("<h1>Error: File not found in the request</h1>");
    }else{
        InputStream fileContent = filePart.getInputStream();
        // Read the CSV data and store it in a List of objects
        Customer customer = new Customer(fName, lName, dob);
        List<FinancialData> financialData = readCSV(fileContent);
        // Store the data in a database
        DAO storeInDB = new CustomerModel();
        storeInDB.addCustomer(customer, financialData);
        response.sendRedirect("visuals.jsp");
 }
    }

    private List<FinancialData> readCSV(InputStream inputStream) {
        List<FinancialData> financialData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }

                String[] values = line.split(",");
                FinancialData data = new FinancialData();
                data.setMonth(values[0]);

                data.setIncome(Double.parseDouble(values[1].replace("R", "").trim()));
                data.setCosts(Double.parseDouble(values[2].replace("R", "").trim()));
                financialData.add(data);
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return financialData;
    }
}
