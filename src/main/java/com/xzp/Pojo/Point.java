package com.xzp.Pojo;

public class Point {
    private String course;
    private String time;
    private String point;
    private String m;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "Point{" +
                "course='" + course + '\'' +
                ", time='" + time + '\'' +
                ", point='" + point + '\'' +
                ", m='" + m + '\'' +
                '}';
    }
}
