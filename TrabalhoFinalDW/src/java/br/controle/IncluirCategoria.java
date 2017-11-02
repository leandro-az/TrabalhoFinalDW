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

@WebServlet(name = "IncluirCategoria", urlPatterns = {"/IncluirCategoria"})
public class IncluirCategoria extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String descricao= request.getParameter("descricao");

 // ========================================= faz a verificação de dados ============================================       

        try {
            
            request.setAttribute("erro_nome", "");

            if ((descricao.isEmpty() )  )// verifica os dados
            {  // retorna para o formulario de contato

             request.setAttribute("erro_nome", "O nome não pode ser vazio");
                
// ====================================== se dados errados chama o forms de insere ADM novamente ==========================
                RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
                rd.forward(request, response);
            } else {

              Categoria cat = new Categoria(descricao);
                Categoria_DAO cat_dao = new Categoria_DAO();
                try {
                    cat_dao.Inserir(cat);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
// =========================== se tudo ok chama metodo listar Categorias passando para resposta =================================================================================================                    
                    request.setAttribute("retorna", "ListaCategoria");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            request.setAttribute("erro_idade", "A idade não pode ser menor que 18");
  //========================= se algum dado estiver errado devolve o form do ADM ===========================          
            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
            rd.forward(request, response);
        }

    }

}