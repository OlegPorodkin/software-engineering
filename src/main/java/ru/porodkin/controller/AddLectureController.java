package ru.porodkin.controller;

import ru.porodkin.model.dao.*;
import ru.porodkin.model.entity.Lecture;
import ru.porodkin.model.entity.Lecturer;
import ru.porodkin.model.entity.TypeOfWork;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(urlPatterns = "/lectures/add")
public class AddLectureController extends HttpServlet {

    private TypeOfWorkDao typeOfWork = new TypeOfWorkDaoImpl();
    private LecturerDao lecturer = new LecturerDaoImpl();
    private LectureDao lectureDao = new LectureDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<TypeOfWork> typeOfWorkAll = typeOfWork.getAll();
        List<Lecturer> lecturerAll = lecturer.getAll();

        request.setAttribute("type_of_works", typeOfWorkAll);
        request.setAttribute("lectures", lecturerAll);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_lectures.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Lecture lecture = new Lecture();
        Lecturer lecturer = new Lecturer();
        TypeOfWork typeOfWork = new TypeOfWork();

        lecturer.setId(Long.parseLong(request.getParameter("lecturers")));
        typeOfWork.setId(Long.parseLong(request.getParameter("type_of_work")));
        lecture.setLectureName(request.getParameter("lecture_name"));
        lecture.setLecturer(lecturer);
        lecture.setTypeOfWork(typeOfWork);
        lecture.setSchedule(request.getParameter("schedule"));
        lecture.setTask(request.getParameter("task"));
        //TODO реализовать сохранение BLOB файлов
        // lecture.setResources(request.getParameter("res"));

        System.out.println(lectureDao.save(lecture));

        response.sendRedirect("/lectures");
    }
}
