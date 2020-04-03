package com.example;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "Student")
@Entity
public class Student {
    private String Name;
    private String StuNum;
    private int id;

    public Student() {

    }

    public Student(String Name, String StuNum, int id) {
        this.id = id;
        this.Name = Name;
        this.StuNum = StuNum;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStuNum() {
        return StuNum;
    }

    public void setStuNum(String stuNum) {
        StuNum = stuNum;
    }
}
