package com.xzp.Pojo;



//id int primary key auto_increment,
//name varchar(10),
//sex char(1),
//phonenumber varchar(20),
//college varchar(10),
//course1 varchar(10),
//course2 varchar(10),
//course3 varchar(10)

import java.util.Arrays;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private String phonenumber;
    private String college;
    private List<String> courses;
    private String sex;
    // 最终要使用的集合
    // ===== 三门课setter，赋值自动封装List =====
    // courses只留getter
    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", college='" + college + '\'' +
                ", courses=" + courses +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

}
