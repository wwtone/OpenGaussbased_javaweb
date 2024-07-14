package com.controller.manager;

import com.Beans.Student;
import com.Dao.StudentDao;
import com.DaoImpl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String studentID = request.getParameter("studentID");
        String studentName = request.getParameter("studentName");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String hometown = request.getParameter("hometown");
        String classID = request.getParameter("classID");

        Student student = new Student();
        student.setStudentID(studentID);
        student.setStudentName(studentName);
        student.setGender(gender);
        student.setAge(age);
        student.setHometown(hometown);
        student.setClassID(classID);

        StudentDao studentDao = new StudentDaoImpl();
        try {
            studentDao.addStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("searchStudentServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request,response);
    }
}
