package com.controller.manager;

import com.Beans.Student;
import com.Beans.Teacher;
import com.Dao.ImportDao;
import com.DaoImpl.ImportDaoImpl;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/adminImport")
@MultipartConfig
public class ManagerImport extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("fileUpload");
        InputStream fileContent = filePart.getInputStream();

        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(fileContent)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                String identity = getCellValue(row.getCell(0));
                String id = getCellValue(row.getCell(1));
                String name = getCellValue(row.getCell(2));
                String gender = getCellValue(row.getCell(3));
                int age = Integer.parseInt(getCellValue(row.getCell(4)));

                if ("学生".equals(identity)) {
                    String hometown = getCellValue(row.getCell(5));
                    Student student = new Student(null, id, name, gender, age, 0, hometown, null);
                    students.add(student);
                } else if ("教师".equals(identity)) {
                    String title = getCellValue(row.getCell(6));
                    String contactNumber = getCellValue(row.getCell(7));
                    Teacher teacher = new Teacher(id, name, gender, age, title, contactNumber);
                    teachers.add(teacher);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "文件导入成功！");
            request.getRequestDispatcher("manager_import_info.jsp").forward(request,response);

            return;
        }

        ImportDao importDao = new ImportDaoImpl();
        importDao.importStudents(students);
        importDao.importTeachers(teachers);

        request.setAttribute("message", "文件导入成功！");
        request.getRequestDispatcher("manager_import_info.jsp").forward(request,response);

    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }

    private int getIntCellValue(Cell cell) {
        if (cell == null) {
            return 0;
        }
        cell.setCellType(CellType.STRING);
        return Integer.parseInt(cell.getStringCellValue());
    }
}
