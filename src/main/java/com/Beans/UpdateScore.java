package com.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateScore {
    private String teacherId;
    private String studentId;
    private String studentName;
    private String courseId;
    private String courseName;
    private String semester;
    private int score;

}
