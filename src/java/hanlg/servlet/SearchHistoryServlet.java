/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import hanlg.tblHistoryScore.tblHistoryScoreDAO;
import hanlg.tblHistoryScore.tblHistoryScoreDTO;
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

/**
 *
 * @author DELL
 */
public class SearchHistoryServlet extends HttpServlet {

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
            throws ServletException, IOException ,NullPointerException{
        response.setContentType("text/html;charset=UTF-8");
      
 PrintWriter out = response.getWriter();
        String url = "showHistory.jsp";
         String currentpagestr = request.getParameter("page");
        String studentID = request.getParameter("studentID");
        String subject = request.getParameter("subject"); 
        HttpSession session = request.getSession();
        int page;
        
         try {
             tblHistoryScoreDAO dao = new tblHistoryScoreDAO();
           if(subject.equalsIgnoreCase("All"))
           {
                int currentpage;
                if (currentpagestr == null) {
                    currentpage = 1;
                } else {
                    currentpage = Integer.parseInt(currentpagestr);
                }
               
                int count = dao.countAllHistory(studentID);

                if (count % 5 == 0) {
                    page = count / 5;
                } else {
                    page = count / 5 + 1;
                }
                request.setAttribute("COUNT", page);
                request.setAttribute("currentpage", currentpage);
                if (count > 0) {
                    dao.getAllHistory(currentpage,studentID);
                }
            
           }else{
              int currentpage;
                if (currentpagestr == null) {
                    currentpage = 1;
                } else {
                    currentpage = Integer.parseInt(currentpagestr);
                }
               
                int count = dao.countHistorybaseSubject(subject,studentID);

              if (count % 5 == 0) {
                    page = count / 5;
                } else {
                    page = count / 5 + 1;
                }
                request.setAttribute("COUNT", page);
                request.setAttribute("currentpage", currentpage);
                if (count > 0) {
                    dao.getHistorybaseSubject(currentpage,subject,studentID);
                } 
           }
            List<tblHistoryScoreDTO> listHistory = dao.getHistoryList();
            request.setAttribute("LISTHISTORY", listHistory);

        } catch (SQLException ex) {
            log("ShowProductServlet[SQLException]=" + ex.getMessage());
        } catch (NamingException ex) {
            log("ShowProductServlet[NamingException]=" + ex.getMessage());

        } catch (ClassNotFoundException ex) {
            log("ShowProductServlet[ClassNotFoundException]=" + ex.getMessage());
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
