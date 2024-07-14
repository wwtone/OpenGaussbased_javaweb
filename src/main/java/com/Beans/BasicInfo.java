package com.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicInfo implements Serializable {
    private String studentID;
    private String name;
    private String namePY;
    private String gender;
    private String nation;
    private Date birthDate;
    private String nativePlace;
    private String politicalStatus;
    private String IDType;
    private String IDNumber;

}
