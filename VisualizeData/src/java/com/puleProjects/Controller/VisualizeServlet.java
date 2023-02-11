/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleProjects.Controller;

import com.puleProjects.utils.TemporalGraph;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PULE
 */
@WebServlet(name = "VisualizeServlet", urlPatterns = {"/VisualizeServlet"})
public class VisualizeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        TemporalGraph.draw();
        response.sendRedirect("visuals.jsp");
        
        
    }


}
