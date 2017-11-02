/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Cliente;
import br.DAO.Cliente_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leandro
 */
@WebServlet(name = "ListaCliente", urlPatterns = {"/ListaCliente"})
public class ListaCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente_DAO cliente_dao = new Cliente_DAO();
        ArrayList<Cliente> meusClientes = cliente_dao.Listar();
        request.setAttribute("meusClientes", meusClientes);
// ====================  chamar o lista cliente view correto ======================================================        
        RequestDispatcher rd = request.getRequestDispatcher("ListaContatoView.jsp");
        rd.forward(request, response);

    }

}
