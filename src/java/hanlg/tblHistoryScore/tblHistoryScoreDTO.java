/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblHistoryScore;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class tblHistoryScoreDTO {
     private int historyId;
     private String subjectId;
     private String studentId;
     private int countCorrectAnswer;
     private int score;
     private Date submitDate;

    public tblHistoryScoreDTO(String subjectId, String studentId, int countCorrectAnswer, int score, Date submitDate) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.countCorrectAnswer = countCorrectAnswer;
        this.score = score;
        this.submitDate = submitDate;
    }

    public tblHistoryScoreDTO() {
    }

    public tblHistoryScoreDTO(int historyId, String subjectId, String studentId, int countCorrectAnswer, int score, Date submitDate) {
        this.historyId = historyId;
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.countCorrectAnswer = countCorrectAnswer;
        this.score = score;
        this.submitDate = submitDate;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getCountCorrectAnswer() {
        return countCorrectAnswer;
    }

    public void setCountCorrectAnswer(int countCorrectAnswer) {
        this.countCorrectAnswer = countCorrectAnswer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
     
}
