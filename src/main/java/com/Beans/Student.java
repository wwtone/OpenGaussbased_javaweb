package com.Beans;

import java.io.Serializable;
public class Student implements Serializable{
    private String classID;
    private String studentID;
    private String studentName;
    private String major;
    private String gender;
    private int age;
    private int earnedCredits;//revise it,not very suitable
    private String hometown;

    // Constructors
    public Student() {
    }
    public Student(String classID, String studentID, String studentName,String gender, int age, int earnedCredits, String hometown,String major) {
        this.classID = classID;
        this.studentID = studentID;
        this.studentName = studentName;
        this.gender =   gender;
        this.age = age;
        this.earnedCredits = earnedCredits;
        this.hometown = hometown;
        this.major=major;
    }
    public String getClassID() {
        return classID;
    }
    public void setClassID(String classID) {
        this.classID = classID;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEarnedCredits() {
        return earnedCredits;
    }

    public void setEarnedCredits(int earnedCredits) {
        this.earnedCredits = earnedCredits;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
    public String getMajor(){
        return major;
    }
    public void setMajor(String major){
        this.major = major;
    }
}

