
package com.cab.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cab.utils.DBConnection;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


@WebServlet(name="RptProductServlet", urlPatterns={"/RptProductServlet.sales"})
public class RptProductServlet extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RptProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RptProductServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        int UserBranch = Integer.parseInt(request.getSession().getAttribute("Branch").toString());
        
        String BranchType = request.getSession().getAttribute("BType").toString();
        String UserType = request.getSession().getAttribute("Type").toString();
        
        if(UserType.equals("Administrator")){ 
        
            JasperReport jasperReport = null;
            JasperDesign jasperDesign = null;
            Map parameters = new HashMap();
            try{
            String path = getServletContext().getRealPath("/WEB-INF/");
            jasperDesign = JRXmlLoader.load(path + "/reportProduct.jrxml");
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters, DBConnection.getInstance().connection);
            OutputStream outStream = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setContentLength(byteStream.length);
            outStream.write(byteStream, 0, byteStream.length);
            }
            catch(Exception exr)
            {

            }
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/views/error404.jsp").forward(request, response);
        }
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
