package com.controller.teacher;

import com.Beans.TeacherSchedule;
import com.Dao.TeacherScheduleDAO;
import com.DaoImpl.TeacherScheduleDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherSelfScheduleServlet")
public class TeacherSelfScheduleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String academicYear = request.getParameter("academicYear");
        String semester = request.getParameter("semester");
//        semester = academicYear + semester;
        String teacherID = (String) request.getSession().getAttribute("teacherID");

        TeacherScheduleDAO scheduleDAO = new TeacherScheduleDAOImpl();
        List<TeacherSchedule> schedules = scheduleDAO.getTeacherSchedule(academicYear,semester, null, null, teacherID);
        for (TeacherSchedule schedule : schedules) {
            System.out.println("Teacher ID: " + schedule.getTeacherID());
            System.out.println("Teacher Name: " + schedule.getTeacherName());
            System.out.println("Course ID: " + schedule.getCourseID());
            System.out.println("Course Name: " + schedule.getCourseName());
            System.out.println("Title: " + schedule.getTitle());
            System.out.println("Semester: " + schedule.getSemester());
            System.out.println("-----------");
        }
        if (schedules == null || schedules.isEmpty()) {
            request.getSession().setAttribute("errorMessage", "没有找到记录");
            response.sendRedirect("teacher_teacherSearchSchedule.jsp");
        } else {
            request.setAttribute("teacherScheduleList", schedules);
            request.getRequestDispatcher("teacher_teacherSearchSchedule.jsp").forward(request, response);
        }
    }
}
