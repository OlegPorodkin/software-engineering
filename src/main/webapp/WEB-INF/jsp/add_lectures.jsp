<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stixl
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Добавить предмет</title>
    </head>
    <body>
        <div>
            <section>
                <form method="post" action="${pageContext.request.contextPath}/lectures/add">
                    <table >
                        <tr>
                            <th>Предмет</th>
                            <th>Преподаватель<a href="${pageContext.request.contextPath}/lecturer/add"> add</a></th>
                            <th>Тип зачета</th>
                            <th>Расписание</th>
                            <th>Задание</th>
                            <th>Ресурсы для скачивания</th>
                        </tr>
                        <tr>
                            <th>
                                <textarea name="lecture_name" placeholder="Введите название предмета"></textarea>
                            </th>
                            <th>
                                <select name="lecturers">
                                    <c:forEach items="${lectures}" var="lecturer">
                                        <option value="${lecturer.id}">${lecturer.fullName}</option>
                                    </c:forEach>
                                </select>
                            </th>
                            <th>
                                <select name="type_of_work">
                                    <c:forEach items="${type_of_works}" var="work">
                                        <option value="${work.id}">${work.typeWork}</option>
                                    </c:forEach>
                                </select>
                            </th>
                            <th>
                                <textarea name="schedule" placeholder="Введите расписание"></textarea>
                            </th>
                            <th>
                                <textarea name="task" placeholder="Введите задание"></textarea>
                            </th>
                            <th>
                                <input name="res" type="text">
                            </th>
                        </tr>
                    </table>
                    <button type="submit">Добавить</button>
                </form>
            </section>
        </div>
    </body>
</html>
