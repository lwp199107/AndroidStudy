package com.example.fourthday.view;

/**
 * Created by Aslan on 2016/9/10.
 */
public class Student {
    private int _id;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                '}';
    }
}
