<%@page import="br.DAO.Contato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
        <style>
        input:-moz-read-only { /* For Firefox */
            background-color: #DCDCDC;
        }

        input:read-only {
            background-color: #DCDCDC;
        }
        </style>
    </head>
    <body>
        <h1>Lista de Contatos</h1>
        <h1>Excluir Contato</h1>
        <% Contato contato = (Contato) request.getAttribute("contato"); 
        %>
        <form action="Excluir" method="Post">
            
            <input type="hidden" name="id" value="<%=contato.getId()%>" >
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=contato.getNome() %>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_idade") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idade"));%></h3>        
            <% }%>
            Idade:<br>
            <input type="text" name="idade" value="<%=contato.getIdade()%>" readonly="" >
            <br><br>
            <input type="submit" value="Confirmar Exclusão">
            <a href="ListaContato">Retorna</a>
        </form> 
    </body>
</html>
