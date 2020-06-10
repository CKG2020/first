package com.example.hsqTest;

import java.util.Objects;
import java.util.Set;

public class CourseEntity {
    private int cid;
    private String cname;
    private Integer ccredit;
    private Set<StudCourseEntity> studcourse;

    public int getCid() {
        return cid;
    }

    public Set<StudCourseEntity> getStudcourse() {
        return studcourse;
    }

    public void setStudcourse(Set<StudCourseEntity> studcourse) {
        this.studcourse = studcourse;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCcredit() {
        return ccredit;
    }

    public void setCcredit(Integer ccredit) {
        this.ccredit = ccredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return cid == that.cid &&
                Objects.equals(cname, that.cname) &&
                Objects.equals(ccredit, that.ccredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, cname, ccredit);
    }
}
