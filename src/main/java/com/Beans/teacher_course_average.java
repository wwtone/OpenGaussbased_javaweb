package com.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class teacher_course_average {
    private String teacherID;
    private String courseID;
    private String courseName;
    private String time;
    private double averageScore;
}
