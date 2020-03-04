<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="log"
             class="beans.login"
             scope="session"
             />
<jsp:useBean id="account"
             class="beans.Account"
             scope="session"
             />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loading account</title>
    </head>
    <body>
        <h1>Loading Account...</h1>
        <%
            account.setCognome(log.getUserAccount().getCognome());
            account.setNome(log.getUserAccount().getNome());
            account.setPassword(log.getUserAccount().getPassword());
            account.setUsername(log.getUserAccount().getUsername());
            response.sendRedirect("provahome.jsp");
        %>
    </body>
</html>
