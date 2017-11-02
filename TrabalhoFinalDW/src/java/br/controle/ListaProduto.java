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

import br.DAO.Produto;
import br.DAO.Produto_DAO;
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
@WebServlet(name = "ListaProduto", urlPatterns = {"/ListaProduto"})
public class ListaProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produto_DAO prod_dao = new Produto_DAO();
        ArrayList<Produto> meusProdutos = prod_dao.Listar();
        request.setAttribute("meusProdutos", meusProdutos);
// ====================  chamar o lista Produto view correto ======================================================        
        RequestDispatcher rd = request.getRequestDispatcher("ListaProdutoView.jsp");
        rd.forward(request, response);

    }

}
