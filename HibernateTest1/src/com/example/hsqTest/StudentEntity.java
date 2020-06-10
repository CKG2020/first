package com.example.hsqTest;

import java.util.Objects;
import java.util.Set;

public class StudentEntity {
    private int sid;
    private String sname;
    private String ssex;
    private String sdept;
    private Integer sage;
    private String saddress;
    private Set<StudCourseEntity> studcourse;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return sid == that.sid &&
                Objects.equals(sname, that.sname) &&
                Objects.equals(ssex, that.ssex) &&
                Objects.equals(sdept, that.sdept) &&
                Objects.equals(sage, that.sage) &&
                Objects.equals(saddress, that.saddress);
    }


    @Override
    public String toString() {
        return "StudentEntity{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sdept='" + sdept + '\'' +
                ", sage=" + sage +
                ", saddress='" + saddress + '\'' +
                ", studcourse=" + studcourse +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, ssex, sdept, sage, saddress);
    }

    public Set<StudCourseEntity> getStudcourse() {
        return studcourse;
    }

    public void setStudcourse(Set<StudCourseEntity> studcourse) {
        this.studcourse = studcourse;
    }
}
