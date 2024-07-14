package com.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private String studentID;
    private String studentName;
    private String courseName;
    private String semester;
    private double score;
    private int scoreRank;

}
