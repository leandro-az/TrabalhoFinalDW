<%@page import="br.DAO.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <h1>Lista de Contatos</h1>
        <h1>Alterar Dados do Contato</h1>
        <% Cliente cli = (Cliente) request.getAttribute("cliente"); 
        %>
        <form action="Editar" method="POST">
            
            <input type="hidden" name="id" value="<%=contato.getId()%>" >
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=contato.getNome() %>" >
            <br>
            <% if(request.getAttribute("erro_idade") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idade"));%></h3>        
            <% }%>
            Idade:<br>
            <input type="text" name="idade" value="<%=contato.getIdade()%>" >
            <br><br>
            <input type="submit" value="Alterar">
            <a href="ListaContato">Retorna</a>
        </form> 
    </body>
</html>
