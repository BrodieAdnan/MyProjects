<%@page import="java.util.ArrayList"%>
<%@page import="beans.Utente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="contatto"
             class="beans.Utente"
             scope="session"
             />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stile/stile.css" />
        <title>Profilo ${account.cognome} ${account.nome}</title>
    </head>
    <body>
        <h1>Ecco I Tuoi Dati Del Profilo, ${account.cognome} ${account.nome}</h1>
        <%
            ArrayList<Date> accessi = contatto.getAccessi();
            for (int i = 0; i < accessi.size(); i++) {
                out.println(
                        "<p>" + accessi.get(i).getYear() + ", " + accessi.get(i).getMonth() + ", " + accessi.get(i).getDay() + ", " + accessi.get(i).getHour() + ", " + accessi.get(i).getMinutes() + "</p>"
                );
            }
        %>
        <form action="provahome.jsp" >
            <p> <button id="firstLogin" type="submit" value="login">Torna Alla Home Page</button></p>
        </form>
        <form action="doLogout.jsp" >
            <p> <button id="firstLogin" type="submit" value="login">Logout</button></p>
        </form>
    </body>
</html>
