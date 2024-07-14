package com.Beans;

import java.io.Serializable;
public class Teacher implements Serializable{
    private String teacherID;
    private String teacherName;
    private String teacherGender;
    private int teacherAge;
    private String title;
    private String contactNumber;

    // Constructors
    public Teacher() {
    }
    public Teacher(String teacherID, String teacherName, String teacherGender, int teacherAge, String title, String contactNumber) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherGender = teacherGender;
        this.teacherAge = teacherAge;
        this.title = title;
        this.contactNumber = contactNumber;
    }
    // Getters and setters
    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}