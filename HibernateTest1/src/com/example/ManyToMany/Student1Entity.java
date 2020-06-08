package com.example.ManyToMany;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student1", schema = "db1", catalog = "")
public class Student1Entity {
    private int id;
    private String name;
    private Set<Object> courses;

    public Set<Object> getCourses() {
        return courses;
    }

    public void setCourses(Set<Object> courses) {
        this.courses = courses;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1Entity that = (Student1Entity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
