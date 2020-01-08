<%@ page import="ru.porodkin.model.entity.Lecture" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stixl
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Lectures</title>
        <style>
            <%@include file='/WEB-INF/css/Tables.css' %>
        </style>
    </head>
    <body>
        <div>
            <a href="${pageContext.request.contextPath}/">На главную</a>
        </div>
        <div>Список лекций</div>
        <div>
            <table>
                <tr>
                    <th>Предмет</th>
                    <th>Преподаватель</th>
                    <th>Тип зачета</th>
                    <th>Расписание</th>
                    <th>Задание</th>
                    <th>Ресурсы для скачивания</th>
                </tr>
                <c:forEach var="lecture" items="${lectures}">
                    <tr>
                        <td><c:out value="${lecture.lectureName}" /></td>
                        <td width="15%">
                            <a><c:out value="${lecture.lecturer.fullName}" /></a><br/>
                            <a><c:out value="${lecture.lecturer.telephone}" /></a><br/>
                            <a><c:out value="${lecture.lecturer.department.title}" /></a><br/>
                            <a><c:out value="${lecture.lecturer.status}" /></a><br/>
                        </td>
                        <td><c:out value="${lecture.typeOfWork.typeWork}" /></td>
                        <td><c:out value="${lecture.schedule}" /></td>
                        <td><c:out escapeXml="false" value="${lecture.task}" /></td>
                        <td><c:out value="${lecture.resources}" /></td>
                        <td width="10">
                            <a href="/lectures/editing?id=${lecture.id}" >Редактировать</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/lectures/add">Добавить</a>
        </div>
    </body>
</html>
