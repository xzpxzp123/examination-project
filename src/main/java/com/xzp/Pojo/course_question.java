package com.xzp.Pojo;

import java.util.Arrays;
import java.util.List;

public class course_question {
    private String id;
    private String Question_type;
    private String Question;
    private String Option_1;
    private String Option_2;
    private String Option_3;
    private String Option_4;
    private String answer;
    private String point;
    private String course;
    public String getQuestion_type() {
        return Question_type;
    }

    @Override
    public String toString() {
        return "course_question{" +
                "id=" + id +
                ", Question_type='" + Question_type + '\'' +
                ", Question='" + Question + '\'' +
                ", Option_1='" + Option_1 + '\'' +
                ", Option_2='" + Option_2 + '\'' +
                ", Option_3='" + Option_3 + '\'' +
                ", Option_4='" + Option_4 + '\'' +
                ", answer='" + answer + '\'' +
                ", point='" + point + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion_type(String question_type) {
        Question_type = question_type;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }







    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getOption_1() {
        return Option_1;
    }

    public void setOption_1(String option_1) {
        Option_1 = option_1;
    }

    public String getOption_2() {
        return Option_2;
    }

    public void setOption_2(String option_2) {
        Option_2 = option_2;
    }

    public String getOption_3() {
        return Option_3;
    }

    public void setOption_3(String option_3) {
        Option_3 = option_3;
    }

    public String getOption_4() {
        return Option_4;
    }

    public void setOption_4(String option_4) {
        Option_4 = option_4;
    }

}
