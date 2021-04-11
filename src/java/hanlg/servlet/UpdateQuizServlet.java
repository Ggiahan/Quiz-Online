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
public class UpdateQuizServlet extends HttpServlet {

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
        String url = "UpdateQuestion.jsp";
        try {
            HttpSession session = request.getSession();
            String questionId = request.getParameter("questionId");
            String cbSubject = request.getParameter("cbSubject");
            String txtQuestion = request.getParameter("txtQuestion");
            String txtAnswerA = request.getParameter("txtAnswerA");
            String txtAnswerB = request.getParameter("txtAnswerB");
            String txtAnswerC = request.getParameter("txtAnswerC");
            String txtAnswerD = request.getParameter("txtAnswerD");
            String cbCorrect = request.getParameter("cbCorrect");
            String cbStatus = request.getParameter("cbStatus");
            String action = request.getParameter("action");

            tblQuestionandAnswerDAO dao = new tblQuestionandAnswerDAO();
            if (action.equals("SendInfor")) {
                request.setAttribute("cbSubject", cbSubject);
                request.setAttribute("txtQuestion", txtQuestion);
                request.setAttribute("txtAnswerA", txtAnswerA);
                request.setAttribute("txtAnswerB", txtAnswerB);
                request.setAttribute("txtAnswerC", txtAnswerC);
                request.setAttribute("txtAnswerD", txtAnswerD);
                request.setAttribute("cbCorrect", cbCorrect);
                request.setAttribute("questionId", questionId);
                request.setAttribute("cbStatus", cbStatus);
            } else if (action.equals("Update")) {

                String result = dao.CheckQuestionID(Integer.parseInt(questionId));
                if (result != null) {

                    long millis = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);

                    boolean update = dao.updateQuestion(Integer.parseInt(questionId), txtQuestion, txtAnswerA, txtAnswerB, txtAnswerC, txtAnswerD, cbCorrect, cbSubject, Integer.parseInt(cbStatus), date);

                    if (update) {
                        url = "LoadQuestionServlet"
                                + "?search=All";
                    }
                }

            }

        } catch (NamingException ex) {
            Logger.getLogger(UpdateQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();

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
