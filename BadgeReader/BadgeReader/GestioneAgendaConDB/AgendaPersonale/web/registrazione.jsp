<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stile/stile.css"/>
        <title>Registrazione</title>
    </head>
    <body>
        <h1>Registrati Subito:</h1>
        <form action="doRegistration.jsp" >
            <p>Nome: <input type="text" name="nomeUtente" value="${reg.nome}"></p>
            <p>Cognome: <input type="text" name="cognomeUtente" value="${reg.cognome}"></p>
            <p>Username: <input type="text" name="usernameUtente" value="${reg.username}"></p>
            <p>Password: <input type="text" name="passwordUtente" value="${reg.password}"></p>
            <p><button type="submit" value="registra">Registrati</button></p>
        </form>
        <div class="errormessage">${errorReg.message}</div>
        <form action="logIn.jsp" >
            <p> <button id="firstLogin" type="submit" value="login">Torna Alla Pagina Di LogIn</button></p>
        </form>
    </body>
</html>
