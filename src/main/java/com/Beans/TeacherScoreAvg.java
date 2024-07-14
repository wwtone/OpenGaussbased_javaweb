package com.Beans;

public class TeacherScoreAvg {
    private String teacherID;
    private String courseID;
    private String courseName;
    private String time;
    private double averageScore;

    public TeacherScoreAvg(String tID, String cID, String cName, String semester, double avgScore) {
        this.teacherID=tID;
        this.courseID=cID;
        this.courseName=cName;
        this.time=semester;
        this.averageScore=avgScore;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
