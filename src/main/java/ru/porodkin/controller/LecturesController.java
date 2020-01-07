package ru.porodkin.controller;

import ru.porodkin.model.dao.LectureDao;
import ru.porodkin.model.dao.LectureDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lectures")
public class LecturesController extends HttpServlet {

    LectureDao lectureDao = new LectureDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("lectures", lectureDao.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lectures.jsp");
        dispatcher.forward(request, response);
    }
}
