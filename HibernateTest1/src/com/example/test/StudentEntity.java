package com.example.test;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Student", schema = "db1")
public class StudentEntity {
    private String name;
    private String stuNum;
    private int id;

    public StudentEntity() {
    }

    public StudentEntity(String x, String s, int i) {
        this.id = i;
        this.name = x;
        this.stuNum = s;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "StuNum", nullable = false, length = 15)
    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(stuNum, that.stuNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stuNum, id);
    }
}
