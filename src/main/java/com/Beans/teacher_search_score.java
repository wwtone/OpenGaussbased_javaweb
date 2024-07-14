package com.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class teacher_search_score {
    private String studentID;    // 学号
    private String studentName;  // 学生名
    private String courseName;   // 课程名
    private String courseID;     // 课程编号
    private String semester;     // 开课学期
    private float score;         // 成绩
    private String teacherID;    // 老师序号

}
