<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="log"
             class="beans.login"
             scope="session"
             />
<jsp:useBean id="errorLog"
             class="beans.errormessage"
             scope="session"
             />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loging user</title>
    </head>
    <body>
        <h1>Sto elaborando...</h1>
        <%
            log.setUsername(request.getParameter("username"));
            log.setPassword(request.getParameter("password"));
            if (log.tryToLogUser()) {
                response.sendRedirect("doLoadAccount.jsp");
            } else {
                errorLog.setMessage("username o password non valido!");
                response.sendRedirect("logIn.jsp");
            }
        %>
    </body>
</html>
