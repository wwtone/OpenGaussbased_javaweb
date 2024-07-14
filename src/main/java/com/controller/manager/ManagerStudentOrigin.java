package com.controller.manager;

import com.Beans.OriginLocation;
import com.Dao.OriginLocationDao;
import com.DaoImpl.OriginLocationDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminStudentOrigin")
public class ManagerStudentOrigin extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OriginLocationDao originLocationDao = new OriginLocationDaoImpl();
        List<OriginLocation> locationList = originLocationDao.getOriginLocationCounts();

        request.setAttribute("locationList", locationList);
        request.getRequestDispatcher("manager_student_origion.jsp").forward(request, response);
    }
}
