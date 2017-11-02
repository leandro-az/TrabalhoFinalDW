/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author leandroall
 */
package br.controle;

import br.DAO.Categoria;
import br.DAO.Categoria_DAO;
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
@WebServlet(name = "ListaCategoria", urlPatterns = {"/ListaCategoria"})
public class ListaCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Categoria_DAO cat_dado = new Categoria_DAO();
        ArrayList<Categoria> minhasCategorias = cat_dado.Listar();
        request.setAttribute("minhasCategorias", minhasCategorias);
// ====================  chamar o lista ADM  view correto ======================================================        
        RequestDispatcher rd = request.getRequestDispatcher("ListaCategoriaView.jsp");
        rd.forward(request, response);

    }

}
