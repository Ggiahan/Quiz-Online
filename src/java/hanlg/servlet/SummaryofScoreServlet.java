/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import hanlg.AnswerQuiz.AnswerQuizObject;
import hanlg.tblHistoryScore.tblHistoryScoreDAO;
import hanlg.tblHistoryScore.tblHistoryScoreDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class SummaryofScoreServlet extends HttpServlet {

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
        String url = "showScore.jsp";
        HttpSession session = request.getSession();
        String Subject = request.getParameter("Subject");
        String studentID = request.getParameter("studentID");

        AnswerQuizObject ListAnswer = (AnswerQuizObject) session.getAttribute("LISTANSWER");
        tblHistoryScoreDAO dao = new tblHistoryScoreDAO();
        tblQuestionandAnswerDAO questionDAO = new tblQuestionandAnswerDAO();
        int countCorrect = 0;
        int summaryMark = 0;
        try {
            String subjectid = questionDAO.getSubjectID(Subject);
            countCorrect = ListAnswer.countCorrectAnswer();
            summaryMark = ListAnswer.summaryScore();
             SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date SubmitDate = new Date();
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(SubmitDate.getTime()); 
	System.out.println(formatter.format(SubmitDate));
            
           
   //LocalDateTime SubmitDate = LocalDateTime.now();
//            long millis = System.currentTimeMillis();
//            java.util.Date SubmitDate = new java.util.Date(millis);
            //System.out.println(date);
            //long millis = System.currentTimeMillis();
           // java.sql.Time SubmitDate = new java.sql.Time(millis);
            boolean result = dao.InsertHistory(subjectid, studentID, countCorrect, summaryMark,  sqlDate);

            if (result) {
                tblHistoryScoreDTO dto = new tblHistoryScoreDTO(Subject, studentID, countCorrect, summaryMark,  sqlDate);
                request.setAttribute("MARK", dto);
                session.removeAttribute("LISTANSWER");
                session.removeAttribute("LISTQUESTION");
                session.removeAttribute("SELECTANSWERS");

            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryofScoreServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SummaryofScoreServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SummaryofScoreServlet.class.getName()).log(Level.SEVERE, null, ex);
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
