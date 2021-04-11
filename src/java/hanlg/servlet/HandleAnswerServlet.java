/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import hanlg.AnswerQuiz.AnswerQuizObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class HandleAnswerServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        int page;
        String url = "quiz.jsp";
        AnswerQuizObject ListAnswer = (AnswerQuizObject) session.getAttribute("LISTANSWER");
        AnswerQuizObject SelectAnswers = (AnswerQuizObject) session.getAttribute("SELECTANSWERS");
        String btAction = request.getParameter("btAction");
        String correctAnswer = request.getParameter("correctAnswer");
        String Answer = request.getParameter("Answer");
        String Subject = request.getParameter("Subject");
        String studentID = request.getParameter("studentID");
        int currentquestion = Integer.parseInt(request.getParameter("currentquestion"));
        int questionid = Integer.parseInt(request.getParameter("QuestionId"));
        String Phut = request.getParameter("Phút");
        String Giay = request.getParameter("Giây");
        int count = 0;
        try {
            if (ListAnswer == null) {
                ListAnswer = new AnswerQuizObject();
            }
            if (SelectAnswers == null) {
                SelectAnswers = new AnswerQuizObject();
            }//end if cart null
            if (btAction.equalsIgnoreCase("Previous")) {
                count = currentquestion - 1;
            } else if (btAction.equalsIgnoreCase("Next")) {
                count = currentquestion + 1;
            } else if (btAction.equalsIgnoreCase("Submit")) {
                url = "SummaryofScoreServlet?Subject=" + Subject
                        + "&studentID=" + studentID;
            }
            if (Answer != null) {
                SelectAnswers.UpdateAnswer(currentquestion, Answer);
                if (Answer.equalsIgnoreCase(correctAnswer)) {
                    ListAnswer.addmark(questionid, 1);

                } else {
                    ListAnswer.addmark(questionid, 0);

                }
            }
            request.setAttribute("Phút", Phut);
            request.setAttribute("Giây", Giay);
            session.setAttribute("Phút", Phut);
            session.setAttribute("Giây", Giay);
            request.setAttribute("COUNT", count);
            session.setAttribute("LISTANSWER", ListAnswer);
            session.setAttribute("SELECTANSWERS", SelectAnswers);
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
