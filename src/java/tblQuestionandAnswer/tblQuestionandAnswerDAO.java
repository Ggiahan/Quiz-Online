/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblQuestionandAnswer;

import hanlg.tblUser.tblUserDTO;
import hanlg.utilities.DBhelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class tblQuestionandAnswerDAO implements Serializable {

    private List<tblQuestionandAnswerDTO> QuestionList;

    public int countAllQuestionnostatus() throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(questionId) as count "
                        + "from tblQuestionandAnswer "
                        + "where questionId in "
                        + "(select questionId "
                        + "from tblQuestionandAnswer )";
                stm = con.prepareStatement(sqlStatement);

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

    public void getAllQuestion(int pageNumber)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select questionId, question_content, "
                    + "AnswerA,AnswerB,AnswerC, AnswerD, Correct_Answer,"
                    + "statusname,subjectname "
                    + "from tblQuestionandAnswer "
                    + "left JOIN tblStatus "
                    + "on tblQuestionandAnswer.status = tblStatus.statusid "
                    + "left JOIN tblSubject "
                    + "on tblQuestionandAnswer.subjectid = tblSubject.subjectid "
                    + "ORDER BY createDate DESC, questionId OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            rs = stm.executeQuery();

            while (rs.next()) {
                String questionId = rs.getString("questionId");
                String question_content = rs.getString("question_content");
                String AnswerA = rs.getString("AnswerA");
                String AnswerB = rs.getString("AnswerB");
                String AnswerC = rs.getString("AnswerC");
                String AnswerD = rs.getString("AnswerD");
                String Correct_Answer = rs.getString("Correct_Answer");
                String statusname = rs.getString("statusname");
                String subjectname = rs.getString("subjectname");

                tblQuestionandAnswerDTO row = new tblQuestionandAnswerDTO(questionId, question_content, Correct_Answer, AnswerA, AnswerB, AnswerC, AnswerD, statusname, subjectname);
                if (this.QuestionList == null) {
                    this.QuestionList = new ArrayList<>();
                }
                this.QuestionList.add(row);
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

    public int countQuestionbaseSubject(String subject) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(questionId) as count "
                        + "from tblQuestionandAnswer "
                        + "where questionId in "
                        + "(select questionId "
                        + "from tblQuestionandAnswer "
                        + "left JOIN tblSubject "
                        + "on tblQuestionandAnswer.subjectid = tblSubject.subjectid "
                        + "  where tblSubject.subjectname = ? )";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, subject);
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

    public void getQuestionbaseSubject(int pageNumber, String subject)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select questionId, question_content, "
                    + "AnswerA,AnswerB,AnswerC, AnswerD, Correct_Answer,"
                    + "statusname,subjectname "
                    + "from tblQuestionandAnswer "
                    + "left JOIN tblStatus "
                    + "on tblQuestionandAnswer.status = tblStatus.statusid "
                    + "left JOIN tblSubject "
                    + "on tblQuestionandAnswer.subjectid = tblSubject.subjectid "
                    + " where tblSubject.subjectname = ? "
                    + "ORDER BY createDate DESC, questionId OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, subject);
            rs = stm.executeQuery();

            while (rs.next()) {
                String questionId = rs.getString("questionId");
                String question_content = rs.getString("question_content");
                String AnswerA = rs.getString("AnswerA");
                String AnswerB = rs.getString("AnswerB");
                String AnswerC = rs.getString("AnswerC");
                String AnswerD = rs.getString("AnswerD");
                String Correct_Answer = rs.getString("Correct_Answer");
                String statusname = rs.getString("statusname");
                String subjectname = rs.getString("subjectname");

                tblQuestionandAnswerDTO row = new tblQuestionandAnswerDTO(questionId, question_content, Correct_Answer, AnswerA, AnswerB, AnswerC, AnswerD, statusname, subjectname);
                if (this.QuestionList == null) {
                    this.QuestionList = new ArrayList<>();
                }
                this.QuestionList.add(row);
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

    public int countQuestionbaseContent(String Content) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(questionId) as count "
                        + "from tblQuestionandAnswer "
                        + "where questionId in "
                        + "(select questionId "
                        + "from tblQuestionandAnswer "
                        + "left JOIN tblSubject "
                        + "on tblQuestionandAnswer.subjectid = tblSubject.subjectid "
                        + "  where question_content LIKE ? )";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, "%" + Content + "%");
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

    public void getQuestionbaseContent(int pageNumber, String Content)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select questionId, question_content, "
                    + "AnswerA,AnswerB,AnswerC, AnswerD, Correct_Answer,"
                    + "statusname,subjectname "
                    + "from tblQuestionandAnswer "
                    + "left JOIN tblStatus "
                    + "on tblQuestionandAnswer.status = tblStatus.statusid "
                    + "left JOIN tblSubject "
                    + "on tblQuestionandAnswer.subjectid = tblSubject.subjectid "
                    + " where question_content LIKE ? "
                    + "ORDER BY createDate DESC, questionId OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, "%" + Content + "%");
            rs = stm.executeQuery();

            while (rs.next()) {
                String questionId = rs.getString("questionId");
                String question_content = rs.getString("question_content");
                String AnswerA = rs.getString("AnswerA");
                String AnswerB = rs.getString("AnswerB");
                String AnswerC = rs.getString("AnswerC");
                String AnswerD = rs.getString("AnswerD");
                String Correct_Answer = rs.getString("Correct_Answer");
                String statusname = rs.getString("statusname");
                String subjectname = rs.getString("subjectname");

                tblQuestionandAnswerDTO row = new tblQuestionandAnswerDTO(questionId, question_content, Correct_Answer, AnswerA, AnswerB, AnswerC, AnswerD, statusname, subjectname);
                if (this.QuestionList == null) {
                    this.QuestionList = new ArrayList<>();
                }
                this.QuestionList.add(row);
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

    public int countQuestionbaseStatus(String status) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(questionId) as count "
                        + "from tblQuestionandAnswer "
                        + "where questionId in "
                        + "(select questionId "
                        + "from tblQuestionandAnswer "
                        + "left JOIN tblStatus "
                        + "on tblQuestionandAnswer.status = tblStatus.statusid "
                        + "  where tblStatus.statusname = ?)";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, status);
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

    public void getQuestionbaseStatus(int pageNumber, String status)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select questionId, question_content, "
                    + "AnswerA,AnswerB,AnswerC, AnswerD, Correct_Answer,"
                    + "statusname,subjectname "
                    + "from tblQuestionandAnswer "
                    + "left JOIN tblStatus "
                    + "on tblQuestionandAnswer.status = tblStatus.statusid "
                    + "left JOIN tblSubject "
                    + "on tblQuestionandAnswer.subjectid = tblSubject.subjectid "
                    + " where tblStatus.statusname = ? "
                    + "ORDER BY createDate DESC, questionId OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, status);
            rs = stm.executeQuery();

            while (rs.next()) {
                String questionId = rs.getString("questionId");
                String question_content = rs.getString("question_content");
                String AnswerA = rs.getString("AnswerA");
                String AnswerB = rs.getString("AnswerB");
                String AnswerC = rs.getString("AnswerC");
                String AnswerD = rs.getString("AnswerD");
                String Correct_Answer = rs.getString("Correct_Answer");
                String statusname = rs.getString("statusname");
                String subjectname = rs.getString("subjectname");

                tblQuestionandAnswerDTO row = new tblQuestionandAnswerDTO(questionId, question_content, Correct_Answer, AnswerA, AnswerB, AnswerC, AnswerD, statusname, subjectname);
                if (this.QuestionList == null) {
                    this.QuestionList = new ArrayList<>();
                }
                this.QuestionList.add(row);
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

    public String CheckQuestionID(int questionId) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String productid = null;

        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select question_content "
                        + "from tblQuestionandAnswer "
                        + "where questionId = ?";
                stm = con.prepareStatement(sqlStatement);
                stm.setInt(1, questionId);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productid = rs.getString("question_content");

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

        return productid;
    }

    public boolean InsertQuestion(String question_content, String AnswerA, String AnswerB, String AnswerC, String AnswerD, String Correct_Answer, String subjectid, String Creator, int status, Date createDate)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;

        try {
            con = DBhelpers.makeConnection();
            String sql = "INSERT INTO "
                    + "tblQuestionandAnswer(question_content,"
                    + " AnswerA,AnswerB,AnswerC, AnswerD,"
                    + " Correct_Answer,"
                    + "status,"
                    + "subjectid,"
                    + "Creator,"
                    + "createDate)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?)";

            pst = con.prepareStatement(sql);
            pst.setString(1, question_content);
            pst.setString(2, AnswerA);
            pst.setString(3, AnswerB);
            pst.setString(4, AnswerC);
            pst.setString(5, AnswerD);
            pst.setString(6, Correct_Answer);
            pst.setInt(7, status);
            pst.setString(8, subjectid);
            pst.setString(9, Creator);
            pst.setDate(10, (java.sql.Date) createDate);

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

    public boolean updateQuestion(int questionId, String question_content, String AnswerA, String AnswerB, String AnswerC, String AnswerD, String Correct_Answer, String subjectid, int status, Date createDate)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            // 1. connection to db
            con = DBhelpers.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "Update tblQuestionandAnswer "
                        + " Set question_content =?,"
                        + " AnswerA = ?, "
                        + " AnswerB =? , "
                        + " AnswerC =? , "
                        + " AnswerD=? , "
                        + " Correct_Answer = ?, "
                        + " status =? , "
                        + " subjectid =? , "
                        + " createDate=? "
                        + " WHERE questionId= ?";
                //3. create statement
                stm = con.prepareStatement(sql);

                stm.setString(1, question_content);
                stm.setString(2, AnswerA);
                stm.setString(3, AnswerB);
                stm.setString(4, AnswerC);
                stm.setString(5, AnswerD);
                stm.setString(6, Correct_Answer);
                stm.setInt(7, status);
                stm.setString(8, subjectid);

                stm.setDate(9, (java.sql.Date) createDate);
                stm.setInt(10, questionId);
                //4. excute query
                int row = stm.executeUpdate();
                //5. process result
                if (row > 0) {
                    return true;
                }//end while rs
            }//end 
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updatestatus(String questionId)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            // 1. connection to db
            con = DBhelpers.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "Update tblQuestionandAnswer "
                        + " Set status=3 "
                        + " Where questionId = ?";
                //3. create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, questionId);
                int row = stm.executeUpdate();
                //5. process result
                if (row > 0) {
                    return true;
                }//end while rs
            }//end 
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public void getQuiz(String subject)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select top 10 questionId, question_content, AnswerA,AnswerB,AnswerC, AnswerD, Correct_Answer,"
                    + "statusname,subjectname,createDate "
                    + "from tblQuestionandAnswer "
                    + "left JOIN tblStatus "
                    + "on tblQuestionandAnswer.status = tblStatus.statusid "
                    + "left JOIN tblSubject "
                    + "on tblQuestionandAnswer.subjectid = tblSubject.subjectid "
                    + "where tblStatus.statusname = 'Activate' and tblQuestionandAnswer.subjectid =? "
                    + "ORDER BY NEWID() ";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, subject);
            rs = stm.executeQuery();

            while (rs.next()) {
                String questionId = rs.getString("questionId");
                String question_content = rs.getString("question_content");
                String AnswerA = rs.getString("AnswerA");
                String AnswerB = rs.getString("AnswerB");
                String AnswerC = rs.getString("AnswerC");
                String AnswerD = rs.getString("AnswerD");
                String Correct_Answer = rs.getString("Correct_Answer");
                String statusname = rs.getString("statusname");
                String subjectname = rs.getString("subjectname");

                tblQuestionandAnswerDTO row = new tblQuestionandAnswerDTO(questionId, question_content, Correct_Answer, AnswerA, AnswerB, AnswerC, AnswerD, statusname, subjectname);
                if (this.QuestionList == null) {
                    this.QuestionList = new ArrayList<>();
                }
                this.QuestionList.add(row);
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

    public String getSubjectID(String subject) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        String categoryid = null;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select subjectid "
                        + "from tblSubject "
                        + "where subjectname= ?";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, subject);
                rs = stm.executeQuery();
                while (rs.next()) {
                    categoryid = rs.getString("subjectid");
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
        return categoryid;
    }

    public List<tblQuestionandAnswerDTO> getQuestionList() {
        return QuestionList;
    }
}
