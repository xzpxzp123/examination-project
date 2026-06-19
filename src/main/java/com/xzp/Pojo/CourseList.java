package com.xzp.Pojo;

import java.util.List;

public class CourseList {
    private int id;
    private String name;
    private List<Point> lists;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Point> getLists() {
        return lists;
    }

    public void setLists(List<Point> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lists=" + lists +
                '}';
    }
}
