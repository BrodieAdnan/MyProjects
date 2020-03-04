<jsp:useBean id="reg"
             class="beans.registration"
             scope="session"/>

<jsp:useBean id="errorReg"
             class="beans.errormessage"
             scope="session"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stile/stile.css">
        <title>Registering user</title>
    </head>
    <body>
        <h1>Sto elaborando...</h1>
        <%
            reg.setNome(request.getParameter("nomeUtente"));
            reg.setCognome(request.getParameter("cognomeUtente"));
            reg.setUsername(request.getParameter("usernameUtente"));
            reg.setPassword(request.getParameter("passwordUtente"));

            if (reg.isUsernameValid()) {
                reg.registerUser();
                response.sendRedirect("index.jsp");
            } else {
                errorReg.setMessage("Username non valido");
                response.sendRedirect("registrazione.jsp");
            }

        %>
    </body>
</html>
