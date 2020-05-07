package com.example.DepartmentAndUsr;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usr", schema = "db1")
public class UsrEntity {
    private int id;
    private String name;
    private String password;
    private String address;
    private Integer phone;
    private String title;
    private String power;
    private String auth;
    private Integer deptid;
    private Integer homephone;
    private String superauth;
    private Integer groupid;
    private String birthdate;
    private String gender;
    private String email;
    private String nickname;
    private DepartmentEntity departmentEntity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "power")
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Basic
    @Column(name = "auth")
    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Basic
    @Column(name = "deptid")
    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    @Basic
    @Column(name = "homephone")
    public Integer getHomephone() {
        return homephone;
    }

    public void setHomephone(Integer homephone) {
        this.homephone = homephone;
    }

    @Basic
    @Column(name = "superauth")
    public String getSuperauth() {
        return superauth;
    }

    public void setSuperauth(String superauth) {
        this.superauth = superauth;
    }

    @Basic
    @Column(name = "groupid")
    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    @Basic
    @Column(name = "birthdate")
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsrEntity usrEntity = (UsrEntity) o;
        return id == usrEntity.id &&
                Objects.equals(name, usrEntity.name) &&
                Objects.equals(password, usrEntity.password) &&
                Objects.equals(address, usrEntity.address) &&
                Objects.equals(phone, usrEntity.phone) &&
                Objects.equals(title, usrEntity.title) &&
                Objects.equals(power, usrEntity.power) &&
                Objects.equals(auth, usrEntity.auth) &&
                Objects.equals(deptid, usrEntity.deptid) &&
                Objects.equals(homephone, usrEntity.homephone) &&
                Objects.equals(superauth, usrEntity.superauth) &&
                Objects.equals(groupid, usrEntity.groupid) &&
                Objects.equals(birthdate, usrEntity.birthdate) &&
                Objects.equals(gender, usrEntity.gender) &&
                Objects.equals(email, usrEntity.email) &&
                Objects.equals(nickname, usrEntity.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, address, phone, title, power, auth, deptid, homephone, superauth, groupid, birthdate, gender, email, nickname);
    }
}
