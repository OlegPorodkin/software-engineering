package ru.porodkin.controller;

import ru.porodkin.model.dao.DepartmentDao;
import ru.porodkin.model.dao.DepartmentDaoImpl;
import ru.porodkin.model.dao.LecturerDao;
import ru.porodkin.model.dao.LecturerDaoImpl;
import ru.porodkin.model.entity.Department;
import ru.porodkin.model.entity.Lecturer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/lecturer/add")
public class AddLecturerController extends HttpServlet {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    private LecturerDao lecturerDao = new LecturerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Department> allDepartments = departmentDao.getAll();
        request.setAttribute("departments", allDepartments);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_lecturer.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Lecturer lecturer = new Lecturer();
        Department department = new Department();
        department.setId(Long.parseLong(request.getParameter("depart")));
        lecturer.setFullName(request.getParameter("fio"));
        lecturer.setTelephone(request.getParameter("telephone"));
        lecturer.setDepartment(department);
        lecturer.setStatus(request.getParameter("description"));

        System.out.println(lecturerDao.save(lecturer));

        response.sendRedirect("/lectures/add");
    }
}
