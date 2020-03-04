<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Accesso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>
            <%
                ArrayList<Accesso> a = SQLHelper.DBOP.getAccessi();
                for (int i = 0; i < a.size(); i++) {
                    out.println(a.get(i)+"<br>");
                }
            %>
        </p>
    </body>
</html>
