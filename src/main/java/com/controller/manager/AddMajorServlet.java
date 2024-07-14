package com.controller.manager;

import com.Beans.Major;
import com.Dao.DaoException;
import com.Dao.MajorDao;
import com.DaoImpl.MajorDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddMajorServlet")
public class AddMajorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String newMajorID = request.getParameter("newMajorID");
        String newMajorName = request.getParameter("newMajorName");

        MajorDao majorDao = new MajorDaoImpl();
        Major major = new Major(newMajorID, newMajorName);
        try {
            majorDao.addMajor(major);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("manager_major_manage.jsp");
    }
}
