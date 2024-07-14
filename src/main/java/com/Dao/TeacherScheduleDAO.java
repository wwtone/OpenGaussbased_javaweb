package com.Dao;

import com.Beans.TeacherSchedule;

import java.util.List;

public interface TeacherScheduleDAO extends BaseDao {
    List<TeacherSchedule> getTeacherSchedule(String academicYear, String semester, String title, String teacher, String teacherID);
}
