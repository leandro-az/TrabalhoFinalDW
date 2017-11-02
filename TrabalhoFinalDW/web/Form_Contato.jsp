<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Incluir Contato</h1>
        <form action="Incluir" method="POST">
            <% if(
                    (request.getAttribute("erro_nome") != null)
                    || (request.getAttribute("erro_nome") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" >
            <br>
            <% if(request.getAttribute("erro_idade") != null) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idade"));%></h3>        
            <% }%>
            Idade:<br>
            <input type="text" name="idade" >
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>
