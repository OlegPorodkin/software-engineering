package ru.porodkin.controller;

import ru.porodkin.model.dao.*;
import ru.porodkin.model.entity.Lecture;
import ru.porodkin.model.entity.Lecturer;
import ru.porodkin.model.entity.TypeOfWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/lectures/editing")
public class LecturesEditingController extends HttpServlet {

    LectureDao lectureDao = new LectureDaoImpl();
    LecturerDao lecturerDao = new LecturerDaoImpl();
    TypeOfWorkDao typeOfWorkDao = new TypeOfWorkDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Lecture lecture = lectureDao.get(id);
        List<Lecturer> lecturers = lecturerDao.getAll();
        List<TypeOfWork> typeOfWorks = typeOfWorkDao.getAll();

        request.setAttribute("lecture", lecture);
        request.setAttribute("lecturers", lecturers);
        request.setAttribute("type_of_work", typeOfWorks);
        request.getRequestDispatcher("/WEB-INF/jsp/lecture_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(request.getParameter(s));
        }

        response.sendRedirect("/lectures");
    }
}
