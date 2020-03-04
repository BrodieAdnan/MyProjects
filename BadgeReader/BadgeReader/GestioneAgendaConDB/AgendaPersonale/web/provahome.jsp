<%@page import="java.io.IOException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Contatto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="account"
             class="beans.Account"
             scope="session"
             />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stile/stile.css" />
        <title>HomePage</title>
    </head>
    <body>
        <h1>Bentornato ${account.nome} ${account.cognome}</h1>
        <form action="datiUtente.jsp" >
            <p> <button id="firstLogin" type="submit" value="login">Visualizza I Tuoi Dati</button></p>
        </form>
        <form action="profilo.jsp" >
            <p> <button id="firstLogin" type="submit" value="login">Visualizza Il Tuo Profilo</button></p>
        </form>
        <form action="doLogout.jsp" >
            <p> <button id="firstLogin" type="submit" value="login">Logout</button></p>
        </form>
    </body>
</html>
