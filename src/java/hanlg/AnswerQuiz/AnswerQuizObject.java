/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.AnswerQuiz;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class AnswerQuizObject implements Serializable {

    Map<Integer, Integer> Answers;
    Map<Integer, String> SelectAnswers;

    public Map<Integer, String> getSelectAnswers() {
        return SelectAnswers;
    }

    public Map<Integer, Integer> getAnswers() {
        return Answers;
    }

    public void addmark(int Idquestion, int mark) {
        if (this.Answers == null) {
            this.Answers = new HashMap<>();
        }

        if (this.Answers.containsKey(Idquestion)) {
            this.Answers.remove(Idquestion);
        }
        this.Answers.put(Idquestion, mark);
    }

    public void UpdateAnswer(int Idquestion, String Answer) {

        if (this.SelectAnswers == null) {
            this.SelectAnswers = new HashMap<>();
        }

        if (this.SelectAnswers.containsKey(Idquestion)) {
            this.SelectAnswers.remove(Idquestion);
        }
        this.SelectAnswers.put(Idquestion, Answer);
    }
//            //quantity = this.items.get(title) + 1;
//        }

    public int summaryScore() {
        int total = 0;
        for (int questionid : Answers.keySet()) {
            total += this.Answers.get(questionid);
        }
        return total;
    }

    public int countCorrectAnswer() {
        int Count = 0;
        for (int questionid : Answers.keySet()) {
            if (this.Answers.get(questionid) == 1) {
                Count += 1;
            }

        }
        return Count;
    }
}
