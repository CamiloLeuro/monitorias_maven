<%-- 
    Document   : leer
    Created on : 3/09/2018, 08:56:18 PM
    Author     : camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <h2>C de CRUD</h2>
        <form action="Read.htm" method="POST">
            code:
            <input type="text" name="code">
            <h5>${messageerr1}</h5>
            <input type="submit" name = "Consultar" value="Consultar">
        </form>    
        <form action="index.htm" method="POST">
            <input type="submit" name = "Volver" value="Volver">
        </form>
        <table>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Code</th>
            <th>email</th>
          </tr>
          <tr>
            <td>${name}</td>
            <td>${surname}</td>
            <td>${code}</td>
            <td>${mail}</td>
          </tr>
        </table>    
    </body>
</html>
