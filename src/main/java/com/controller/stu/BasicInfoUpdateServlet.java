package com.controller.stu;

import com.Beans.BasicInfo;
import com.DaoImpl.BasicInfoImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BasicInfo_UpdateServlet")
public class BasicInfoUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Extracting data from the request
        String studentID = request.getParameter("studentID");
        String name = request.getParameter("name");
        String namePY = request.getParameter("namePY");
        String gender = request.getParameter("sex");
        String nation = request.getParameter("nation");
        String nativePlace = request.getParameter("nativePlace");
        String politicalStatus = request.getParameter("politicalStatus");
        String IDType = request.getParameter("Type");
        String IDNumber = request.getParameter("IDNumber");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = null;
        try {
            birthDate = sdf.parse(request.getParameter("date"));
        } catch (ParseException e) {
            System.out.println("Error parsing the birth date");
        }

        BasicInfo updatedInfo = new BasicInfo(studentID, name, namePY, gender, nation, birthDate, nativePlace, politicalStatus, IDType, IDNumber);

        BasicInfoImpl basicInfoDao = new BasicInfoImpl(); // Assuming DataSource or DB connection setup in constructor
        try {
            if (basicInfoDao.updateBasicInfo(updatedInfo)) {
                response.sendRedirect("BasicInfoServlet"); // Success page URL
            } else {
                request.setAttribute("errorMessage", "Unable to update profile.");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
