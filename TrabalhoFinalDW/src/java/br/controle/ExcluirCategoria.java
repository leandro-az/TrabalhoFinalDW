/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Categoria;
import br.DAO.Categoria_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leandroall
 */
@WebServlet(name = "ExcluirCategoria", urlPatterns = {"/ExcluirCategoria"})
public class ExcluirCategoria extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Categoria cat = new Categoria(id);
        Categoria_DAO cat_dao = new Categoria_DAO();
        try {
            cat_dao.get(cat);
            request.setAttribute("cat", cat);
//=========================== chamar o form de exclusão correto  para Categoria =======================================================================
            RequestDispatcher rd = request.getRequestDispatcher("Form_Categoria_Excluir.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Categoria cat = new Categoria(id);
        try {
                Categoria_DAO cat_dao = new Categoria_DAO();
                try {
                    cat_dao.Excluir(cat);
                    request.setAttribute("mensagem", "Exclusão Com Sucesso");
 // ================================= chama o metodo de Listar Categoria =================================================================================                   
                    request.setAttribute("retorna", "ListaCategoria");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }

    }
}
