package com.Beans;

import java.io.Serializable;
public class Major implements Serializable{
    private String majorID;
    private String majorName;

    public Major() {
    }
    public Major(String majorID, String majorName) {
        this.majorID = majorID;
        this.majorName = majorName;
    }

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
