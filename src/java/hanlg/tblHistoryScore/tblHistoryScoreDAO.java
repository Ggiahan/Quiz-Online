/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblHistoryScore;

import hanlg.utilities.DBhelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.naming.NamingException;
import tblQuestionandAnswer.tblQuestionandAnswerDTO;

/**
 *
 * @author DELL
 */
public class tblHistoryScoreDAO implements Serializable {

    private List<tblHistoryScoreDTO> HistoryList;

    public List<tblHistoryScoreDTO> getHistoryList() {
        return HistoryList;
    }

    public boolean InsertHistory(String subjectId, String studentId, int countCorrectAnswer, int score, Date submitDate)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;

        try {
            con = DBhelpers.makeConnection();
            String sql = "INSERT INTO "
                    + "tblHistoryScore(subjectId,studentId,countCorrectAnswer,score,submitDate)"
                    + " VALUES(?,?,?,?,?)";

            pst = con.prepareStatement(sql);
            pst.setString(1, subjectId);
            pst.setString(2, studentId);
            pst.setInt(3, countCorrectAnswer);
            pst.setInt(4, score);
            pst.setTimestamp(5, (java.sql.Timestamp)submitDate);
            result = pst.executeUpdate();
            if (result != 0) {
                return true;
            }

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public int countAllHistory( String studentid) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(historyId) as count "
                        + "from tblHistoryScore "
                        + "where historyId in "
                        + "(select historyId "
                        + "from tblHistoryScore "
                        + "where studentId= ?  )";
              
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, studentid);
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return count;
    }

    public void getAllHistory(int pageNumber, String studentid)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (5 * (pageNumber - 1));

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select historyId,subjectId,score,"
                    + "countCorrectAnswer, studentId,submitDate "
                    + "from tblHistoryScore "
                    + "where studentId=?  "
                    + "ORDER BY submitDate desc, historyId OFFSET " + p
                    + "ROWS FETCH NEXT 5 ROWS ONLY";
            
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, studentid);
            rs = stm.executeQuery();

            while (rs.next()) {
                int historyId = rs.getInt("historyId");
                String subjectId = rs.getString("subjectId");
                int score = rs.getInt("score");
                int countCorrectAnswer = rs.getInt("countCorrectAnswer");
                String studentId = rs.getString("studentId");

                String date = rs.getString("submitDate");
               // Date submitDate =rs.getDate("submitDate");
                Date submitDate = convertStringToDate(date);

                tblHistoryScoreDTO row = new tblHistoryScoreDTO(subjectId, studentId, countCorrectAnswer, score, submitDate);
                if (this.HistoryList == null) {
                    this.HistoryList = new ArrayList<>();
                }
                this.HistoryList.add(row);
            }

            //  }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public int countHistorybaseSubject(String subject, String studentid) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(historyId) as count "
                        + "from tblHistoryScore "
                        + "where historyId in "
                        + "(select historyId "
                        + "from tblHistoryScore "
                        + "where subjectId =? and studentId=? )";
               
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, subject);
                stm.setString(2, studentid);
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return count;
    }

    public void getHistorybaseSubject(int pageNumber, String subject, String studentid)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (5 * (pageNumber - 1));

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select historyId,subjectId,score,"
                    + "countCorrectAnswer, studentId,submitDate "
                    + "from tblHistoryScore "
                    + "where subjectId = ? and studentId=?  "
                    + "ORDER BY submitDate desc, historyId OFFSET " + p
                    + "ROWS FETCH NEXT 5 ROWS ONLY";
           
            stm = con.prepareStatement(sqlStatement);
             stm.setString(1, subject);
            stm.setString(2, studentid);
            rs = stm.executeQuery();

            while (rs.next()) {
                int historyId = rs.getInt("historyId");
                String subjectId = rs.getString("subjectId");
                int score = rs.getInt("score");
                int countCorrectAnswer = rs.getInt("countCorrectAnswer");
                String studentId = rs.getString("studentId");

                String date = rs.getString("submitDate");
                Date submitDate = convertStringToDate(date);

                tblHistoryScoreDTO row = new tblHistoryScoreDTO(subjectId, studentId, countCorrectAnswer, score, submitDate);
                if (this.HistoryList == null) {
                    this.HistoryList = new ArrayList<>();
                }
                this.HistoryList.add(row);
            }

            //  }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public static Date convertStringToDate(String dateOfBirth) {
        Date result = null;
        try {
            result = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String convertDateToString(Date DOB) {
        return new SimpleDateFormat("dd-mm-yyyy HH:mm:ss").format(DOB);
    }
}
