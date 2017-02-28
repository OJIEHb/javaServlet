package com.geiko.javaServlet.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Андрей on 27.02.2017.
 */
@Component
public class Guest {
    private int id;
    private String name;
    private String comment;
    private int mark;


    public Guest(String name, String comment, int mark) {
        this.name = name;
        this.comment = comment;
        this.mark = mark;
    }

    @Autowired
    public Guest() {
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", mark=" + mark +
                '}';
    }
}
