package com.puleProjects.Tests;

import com.puleProjects.Bean.Customer;
import com.puleProjects.Bean.FinancialData;
import com.puleProjects.dao.CustomerModel;
import com.puleProjects.dao.DAO;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

public class Test {
    public static void main(String[] args) {
        new Test().run();
    }


  public void run() {
    try (InputStream fileContent = new FileInputStream("C:\\Users\\PULE\\Desktop\\EFP\\Cust1.csv")) {
        String fName = "Pule";
        String lName = "Pule";
        String dob = "16/11/1996";
        Customer customer = new Customer(fName, lName, dob);
        List<FinancialData> financialData = readCSV(fileContent);
        DAO storeInDB = new CustomerModel();
        storeInDB.addCustomer(customer, financialData);
    } catch (IOException ex) {
        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
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