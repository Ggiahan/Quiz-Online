/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblQuestionandAnswer.tblQuestionandAnswerDAO;

/**
 *
 * @author DELL
 */
public class CreateQuestionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        String url = "LoadQuestion";
        try {
            HttpSession session = request.getSession();
            String cbSubject = request.getParameter("cbSubject");
            String txtQuestion = request.getParameter("txtQuestion");
            String txtAnswerA = request.getParameter("txtAnswerA");
            String txtAnswerB = request.getParameter("txtAnswerB");
            String txtAnswerC = request.getParameter("txtAnswerC");
            String txtAnswerD = request.getParameter("txtAnswerD");
            String cbCorrect = request.getParameter("cbCorrect");
            String image = request.getParameter("image");
            String admin = request.getParameter("creator");
            tblQuestionandAnswerDAO dao = new tblQuestionandAnswerDAO();
           

                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);

                boolean result = dao.InsertQuestion(txtQuestion, txtAnswerA, txtAnswerB, txtAnswerC, txtAnswerD, cbCorrect,cbSubject, admin,2, date);
        }catch (SQLException ex) {
            log("CreateProductServlet[SQLException]=" + ex.getMessage());
        } catch (NamingException ex) {
             log("CreateProductServlet[NamingException]=" + ex.getMessage());
            
        } catch (ClassNotFoundException ex) {
            log("CreateProductServlet[ClassNotFoundException]=" + ex.getMessage());
        } finally {
           response.sendRedirect(url);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
