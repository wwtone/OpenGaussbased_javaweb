package com.servlets;

import com.Beans.Student;
import com.Dao.StudentDao;
import com.DaoImpl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String classID = request.getParameter("classID");
        String studentID = request.getParameter("studentID");
        String studentName = request.getParameter("studentName");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        int creditsEarned = Integer.parseInt(request.getParameter("creditsEarned"));
        String hometown = request.getParameter("hometown");
        String major = request.getParameter("major");

        Student student = new Student(classID, studentID, studentName, gender, age, creditsEarned, hometown, major);

        try {
            studentDao.updateStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("manager_stu_manage.jsp");
    }
}
