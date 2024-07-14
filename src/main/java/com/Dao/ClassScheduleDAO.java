package com.Dao;

import com.Beans.ClassSchedule;

import java.util.List;

public interface ClassScheduleDAO extends BaseDao {
    List<ClassSchedule> getClassSchedule(String academicYear, String semester, String classId, String className);
}
