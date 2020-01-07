<%--
  Created by IntelliJ IDEA.
  User: stixl
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add departments</title>
    </head>
    <body>
        <form method="post" name="/departments/add">
            <div>Введите наименование кафедры</div>
            <div>
                <input name="name_department" type="text" maxlength="255">
            </div>
            <button type="submit">Добавить</button>
        </form>
    </body>
</html>
