package com.Beans;

import java.io.Serializable;

public class Admin implements Serializable {
    private String adminName; 
    private String adminPassword;
    private String adminRole;

    // Constructors
    public Admin() {
    }
    public Admin(String adminName, String adminPassword, String adminRole) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminRole = adminRole;
    }
    // Getters and setters
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }
}

