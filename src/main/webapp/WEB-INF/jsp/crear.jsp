<%-- 
    Document   : crear
    Created on : 3/09/2018, 08:56:04 PM
    Author     : camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <h2>C de CRUD</h2>
        <form action="Create.htm" method="POST">
            First name:
            <input type="text" name="firstname">
            <h5>${messageerr1}</h5>
            Last name:
            <input type="text" name="lastname">
            <h5>${messageerr2}</h5>
            code:   
            <input type="text" name="code">
            <h5>${messageerr3}</h5>
            email:   
            <input type="text" name="email">
            <br><br>
            <input type="submit" name = "Registrar" value="Registrar">
        </form>
        <h4>${message}</h4>
        <form action="index.htm" method="POST">
            <input type="submit" name = "Volver" value="Volver">
        </form>
    </body>
</html>
