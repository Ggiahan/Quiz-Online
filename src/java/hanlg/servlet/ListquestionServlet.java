/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
import tblQuestionandAnswer.tblQuestionandAnswerDTO;

/**
 *
 * @author DELL
 */
public class ListquestionServlet extends HttpServlet {

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
         String subject = request.getParameter("subject");
        HttpSession session = request.getSession();
        String url = "student_page.jsp";
        try {
            List<tblQuestionandAnswerDTO> check= (List<tblQuestionandAnswerDTO>) session.getAttribute("LISTQUESTION");
            if(check==null){
            tblQuestionandAnswerDAO dao = new tblQuestionandAnswerDAO();
            dao.getQuiz(subject);
            List<tblQuestionandAnswerDTO> listQuestion = dao.getQuestionList();
            if(listQuestion.size()==10){
                
            session.setAttribute("LISTQUESTION", listQuestion);
            url = "quiz.jsp";
            request.setAttribute("COUNT", 1);
             request.setAttribute("Phút",10);
            request.setAttribute("Giây",0);
            //request.setAttribute("questionid", 1);
            }
        } 
            else{
                String Phut = (String) session.getAttribute("Phút");
        String Giay = (String) session.getAttribute("Giây");
         url = "quiz.jsp";
            request.setAttribute("COUNT", 1);
             request.setAttribute("Phút",Phut);
            request.setAttribute("Giây",Giay);
            }
        }
            catch (NamingException ex) {
            Logger.getLogger(ListquestionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListquestionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListquestionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
