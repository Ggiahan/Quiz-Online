/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblQuestionandAnswer;

/**
 *
 * @author DELL
 */
public class tblQuestionandAnswerDTO {
    private String questionid;
    private String question_content;
    private String Correct_Answer;
    private String AnswerA;
    private String AnswerB; 
    private String AnswerC;
    private String AnswerD;
    private String Status;
    private String subject;

    public tblQuestionandAnswerDTO() {
    }

    public tblQuestionandAnswerDTO(String questionid, String question_content, String Correct_Answer, String AnswerA, String AnswerB, String AnswerC, String AnswerD, String Status, String subject) {
        this.questionid = questionid;
        this.question_content = question_content;
        this.Correct_Answer = Correct_Answer;
        this.AnswerA = AnswerA;
        this.AnswerB = AnswerB;
        this.AnswerC = AnswerC;
        this.AnswerD = AnswerD;
        this.Status = Status;
        this.subject = subject;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public String getCorrect_Answer() {
        return Correct_Answer;
    }

    public void setCorrect_Answer(String Correct_Answer) {
        this.Correct_Answer = Correct_Answer;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String AnswerA) {
        this.AnswerA = AnswerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String AnswerB) {
        this.AnswerB = AnswerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String AnswerC) {
        this.AnswerC = AnswerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String AnswerD) {
        this.AnswerD = AnswerD;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

     
    
}
