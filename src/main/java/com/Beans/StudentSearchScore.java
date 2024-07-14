package com.Beans;

import java.util.Objects;

public class StudentSearchScore {
    private String semester;
    private String courseID;
    private String courseName;
    private String studentID;
    private String studentName;
    private int courseCredits;
    private int score;

    // Default Constructor
    public StudentSearchScore() {
    }

    // Parameterized Constructor
    public StudentSearchScore(String semester, String courseID, String courseName, String studentID, String studentName, int courseCredits, int score) {
        this.semester = semester;
        this.courseID = courseID;
        this.courseName = courseName;
        this.studentID = studentID;
        this.studentName = studentName;
        this.courseCredits = courseCredits;
        this.score = score;
    }

    // Getters and Setters
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // toString Method
    @Override
    public String toString() {
        return "StudentSearchScore{" +
                "semester='" + semester + '\'' +
                ", courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", courseCredits=" + courseCredits +
                ", score=" + score +
                '}';
    }

    // hashCode Method
    @Override
    public int hashCode() {
        return Objects.hash(semester, courseID, courseName, studentID, studentName, courseCredits, score);
    }

    // equals Method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentSearchScore that = (StudentSearchScore) o;
        return courseCredits == that.courseCredits &&
                score == that.score &&
                Objects.equals(semester, that.semester) &&
                Objects.equals(courseID, that.courseID) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(studentID, that.studentID) &&
                Objects.equals(studentName, that.studentName);
    }
}
