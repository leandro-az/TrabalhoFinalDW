/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Produto;
import br.DAO.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirProduto", urlPatterns = {"/IncluirProduto"})
public class IncluirProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String descricao= request.getParameter("descricao");
        int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
        double valor = Double.parseDouble(request.getParameter("valor"));

 // ========================================= faz a verificação de dados ============================================       

        try {
            
            request.setAttribute("erro_nome", "");

            if ((descricao.isEmpty() ) || (nome.isEmpty()) || (id_categoria <1) || valor < 0 )// verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (descricao.isEmpty()) {
                    request.setAttribute("erro_descricao", "A descricao não pode ser vazia");
                }
                
                 if (id_categoria <1) {
                    request.setAttribute("erro_cat", "categoria invalida");
                }
                 if (valor < 0) {
                    request.setAttribute("erro_val", " valor negativo");
                }
// ====================================== se dados errados chama o forms de insere Produto novamente ==========================
                RequestDispatcher rd = request.getRequestDispatcher("Form_Produto.jsp");
                rd.forward(request, response);
            } else {

              Produto prod = new Produto( descricao, id_categoria, valor,nome);
                Produto_DAO prod_dao = new Produto_DAO();
                try {
                    prod_dao.Inserir(prod);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
// =========================== se tudo ok chama metodo listar Produto passando para resposta =================================================================================================                    
                    request.setAttribute("retorna", "ListaProduto");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            request.setAttribute("erro_descricao", "A descricao não pode ser vazia");
            request.setAttribute("erro_cat", "categoria invalida");
              request.setAttribute("erro_val", " valor negativo");
  //========================= se algum dado estiver errado devolve o form do produto ===========================          
            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
            rd.forward(request, response);
        }

    }

}