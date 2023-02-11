package com.puleProjects.utils;


import com.puleProjects.utils.ConnectionDB;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PULE
 */


public class TemporalGraph extends JFrame {
        private Connection con;
        private ResultSet resultSet;
    private PreparedStatement ps;
    public TemporalGraph(){}
   public TemporalGraph(String title) {
      super(title);

      // Load data from the database
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      try {
                  con = ConnectionDB.getInstance();
      
         Statement statement = con.createStatement();
          resultSet = statement.executeQuery("SELECT Month, Income, Expenses FROM customer");
         while (resultSet.next()) {
            String month = resultSet.getString("Month");
            double salary = resultSet.getDouble("Income");
            double expenses = resultSet.getDouble("Expenses");
            dataset.addValue(salary, "Income", month);
            dataset.addValue(expenses, "Expenses", month);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      // Create the chart
      JFreeChart chart = ChartFactory.createLineChart(
            "Salary and Expenses over Time", 
            "Month", 
            "Amount", 
            dataset, 
            PlotOrientation.VERTICAL, 
            true, 
            true, 
            false
      );

      // Create a panel to display the chart
      ChartPanel panel = new ChartPanel(chart);
      panel.setPreferredSize(new Dimension(1020, 720));
      setContentPane(panel);
   }


   public static void draw() {
      TemporalGraph chart = new TemporalGraph("Temporal Graph");
      chart.pack();
      chart.setVisible(true);
   }
   
   
       public static void main(String[] args) {
draw();
    }
}
