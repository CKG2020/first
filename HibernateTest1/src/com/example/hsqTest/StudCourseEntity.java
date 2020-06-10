package com.example.hsqTest;

import java.util.Objects;

public class StudCourseEntity {
    private int stuCourseId;
    private int grade;

//    @Override
//    public String toString() {
//        return "StudCourseEntity{" +
//                "stuCourseId=" + stuCourseId +
//                ", grade=" + grade +
//                ", student=" + student +
//                ", course=" + course +
//                '}';
//    }

    private StudentEntity student;

    private CourseEntity course;

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public int getStuCourseId() {
        return stuCourseId;
    }

    public void setStuCourseId(int stuCourseId) {
        this.stuCourseId = stuCourseId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudCourseEntity that = (StudCourseEntity) o;
        return stuCourseId == that.stuCourseId &&
                grade == that.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuCourseId, grade);
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
