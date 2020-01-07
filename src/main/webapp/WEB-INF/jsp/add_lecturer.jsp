<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.porodkin.model.entity.Department" %><%--
  Created by IntelliJ IDEA.
  User: stixl
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Лектор</title>
    </head>
    <body>
        <section>
            <form method="post" action="${pageContext.request.contextPath}/lecturer/add">
                <table>
                    <tr>
                        <th>ФИО преподователя</th>
                        <th>
                            <textarea name="fio" required></textarea>
                        </th>
                    </tr>
                    <tr>
                        <th>Телефон</th>
                        <th>
                            <textarea name="telephone"></textarea>
                        </th>
                    </tr>
                    <tr>
                        <th>Кафедра<a href="${pageContext.request.contextPath}/departments/add"> add</a></th>
                        <th>
                            <select name="depart">
                                <c:forEach items="${departments}" var="department">
                                    <option value="${department.id}">${department.title}</option>
                                </c:forEach>
                            </select>
                        </th>
                    </tr>
                    <tr>
                        <th>Заметки</th>
                        <th>
                            <textarea name="description"></textarea>
                        </th>
                    </tr>
                </table>
                <button type="submit">Добавить</button>
            </form>
        </section>
    </body>
</html>
