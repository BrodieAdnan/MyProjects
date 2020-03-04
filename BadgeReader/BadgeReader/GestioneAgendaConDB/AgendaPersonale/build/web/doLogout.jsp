<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="account"
             class="beans.Account"
             scope="session"
             />
<jsp:useBean id="log"
             class="beans.login"
             scope="session"
             />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logging Out</title>
    </head>
    <body>
        <h1>Logging out...Please Wait</h1>
        <%
            account.doLogout();
            log.setPassword("");
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
