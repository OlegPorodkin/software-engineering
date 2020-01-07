package ru.porodkin.controller;

import ru.porodkin.model.dao.DepartmentDao;
import ru.porodkin.model.dao.DepartmentDaoImpl;
import ru.porodkin.model.entity.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/departments/add")
public class AddDepartmentController extends HttpServlet {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        List<Department> departments = departmentDao.getAll();

        request.setAttribute("all_departments", departments);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_departments.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name_department = request.getParameter("name_department");
        Department department = new Department();
        department.setTitle(name_department);

        System.out.println(departmentDao.save(department));

        response.sendRedirect("/lecturer/add");
    }
}
