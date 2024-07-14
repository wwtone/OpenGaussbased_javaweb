package com.controller.manager;

import com.Dao.DaoException;
import com.Dao.TeacherDao;
import com.DaoImpl.TeacherDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String teacherID = request.getParameter("teacherID");
        TeacherDao teacherDao = new TeacherDaoImpl();

        try {
            teacherDao.deleteTeacher(teacherID);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        response.sendRedirect("searchTeacherServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request,response);
    }
}
