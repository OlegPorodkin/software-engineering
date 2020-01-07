<%--
  Created by IntelliJ IDEA.
  User: stixl
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lecture edit</title>
</head>
<body>
    <div>
        <jsp:useBean id="lecture" scope="request" type="ru.porodkin.model.entity.Lecture"/>
        <form method="post" name="/lectures/editing">
            <table>
                <tr>
                    <td>Предмет:</td>
                    <td>
                        <input name="lecture_name" type="text" value="<c:out value="${lecture.lectureName}"/>">
                    </td>
                </tr>
                <tr>
                    <td>Преподаватель</td>
                    <td>
                        <select name="lecturers">
                            <c:forEach items="${lecturers}" var="lecturer">
                                <option value="${lecturer.fullName}">${lecturer.fullName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Тип зачета</td>
                    <td>
                        <select name="type_of_work">
                            <c:forEach items="${type_of_work}" var="typeOfWork">
                                <option value="<c:out value="${typeOfWork.typeWork}"/>"><c:out value="${typeOfWork.typeWork}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Расписание</td>
                    <td>
                    <textarea name="schedule">
                        <c:out value="${lecture.schedule}"/>
                    </textarea>
                    </td>
                </tr>
                <tr>
                    <td>Задание</td>
                    <td>
                    <textarea name="task">
                        <c:out value="${lecture.task}"/>
                    </textarea>
                    </td>
                </tr>
                <tr>
                    <td>Ресурсы для скачивания</td>
                </tr>
            </table>
            <button type="submit">Save</button>
        </form>
    </div>
</body>
</html>
