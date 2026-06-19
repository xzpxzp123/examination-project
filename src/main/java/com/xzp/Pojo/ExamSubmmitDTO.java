package com.xzp.Pojo;

import java.util.Map;

public class ExamSubmmitDTO {
    private String studentId;
    private String course;
    private Map<String, Object> answerMap;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public Map<String, Object> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(Map<String, Object> answerMap) {
        this.answerMap = answerMap;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ExamSubmmitDTO{" +
                "studentId='" + studentId + '\'' +
                ", course='" + course + '\'' +
                ", answerMap=" + answerMap +
                '}';
    }
}
