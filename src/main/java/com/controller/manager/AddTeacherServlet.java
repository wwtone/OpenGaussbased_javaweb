package com.controller.manager;

import com.Beans.Teacher;
import com.Dao.DaoException;
import com.Dao.TeacherDao;
import com.DaoImpl.TeacherDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String teacherID = request.getParameter("teacherID");
        String teacherName = request.getParameter("teacherName");
        String teacherGender = request.getParameter("teacherGender");
        int teacherAge = Integer.parseInt(request.getParameter("teacherAge"));
        String title = request.getParameter("title");
        String contactNumber = request.getParameter("contactNumber");

        Teacher teacher = new Teacher(teacherID, teacherName, teacherGender, teacherAge, title, contactNumber);
        TeacherDao teacherDao = new TeacherDaoImpl();

        try {
            teacherDao.addteacher(teacher);
        } catch (SQLException | DaoException e) {
            e.printStackTrace();
        }

        response.sendRedirect("searchTeacherServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request,response);
    }
}
