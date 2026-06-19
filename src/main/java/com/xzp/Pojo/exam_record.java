package com.xzp.Pojo;

import java.util.List;

public class exam_record {
    public String course;
    public String student_name;
    public String point;
    public String time;
    public String retake_Flag;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRetake_Flag() {
        return retake_Flag;
    }

    public void setRetake_Flag(String retake_Flag) {
        this.retake_Flag = retake_Flag;
    }

    @Override
    public String toString() {
        return "exam_record{" +
                "course='" + course + '\'' +
                ", student_name='" + student_name + '\'' +
                ", point='" + point + '\'' +
                ", time='" + time + '\'' +
                ", retake_Flag='" + retake_Flag + '\'' +
                '}';
    }
}
