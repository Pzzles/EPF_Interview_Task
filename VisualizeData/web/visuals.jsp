<%-- 
    Document   : visuals
    Created on : 08 Feb 2023, 5:24:27 PM
    Author     : PULE
--%>

<%@page import="java.util.List"%>
<%@page import="com.puleProjects.Bean.Customer"%>
<%@page import="com.puleProjects.dao.DAO"%>
<%@page import="com.puleProjects.dao.CustomerModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="VisualizeServlet" method="get">
            <table class="table">
                <thead>
                    <tr>
                        <th>Customer Name and Surname</th>
                        <th>Month</th>
                        <th>Income</th>
                        <th>Expenses</th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        DAO customerDao = new CustomerModel();
                        List<Customer> dataList = customerDao.viewCustomer();

                        for (Customer customerData : dataList) {

                    %>
                    <tr>
                        <td><%= customerData.getfName() + " " + customerData.getLName()%></td>
                        <td><%= customerData.getMonth()%></td>
                        <td><%= customerData.getIncome()%></td>
                        <td><%= customerData.getExpenses()%></td>
                        <%
                            }
                        %>

                    </tr>
                </tbody>
            </table>
            <button>        
                <a href="VisualizeServlet"> Visualize on Temporal Graph </a>
            </button>   
        </form>

    </body>
</html>
