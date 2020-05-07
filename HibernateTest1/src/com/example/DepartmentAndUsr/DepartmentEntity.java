package com.example.DepartmentAndUsr;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "department", schema = "db1")
public class DepartmentEntity {
    private int id;
    private String name;
    private String description;
    private String status;
    private String goal;
    private Set usrs = new HashSet(0);
//    private  UsrEntity usrEntity;
//
//
//
//    public UsrEntity getUsrEntity() {
//        return usrEntity;
//    }
//
//    public void setUsrEntity(UsrEntity usrEntity) {
//        this.usrEntity = usrEntity;
//    }


    public Set getUsrs() {
        return usrs;
    }

    public void setUsrs(Set usrs) {
        this.usrs = usrs;
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

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "goal")
    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status) &&
                Objects.equals(goal, that.goal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, goal);
    }
}
