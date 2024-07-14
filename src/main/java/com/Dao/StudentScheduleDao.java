package com.Dao;

import com.Beans.ClassSchedule;
import java.util.List;

public interface StudentScheduleDao extends BaseDao {
    List<ClassSchedule> getClassSchedule(String academicYear, String semester, String studentId, String studentName);
}
