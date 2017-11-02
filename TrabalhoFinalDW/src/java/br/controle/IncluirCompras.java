/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Compras;
import br.DAO.Compras_DAO;
import java.io.IOException;
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


@WebServlet(name = "IncluirCompras", urlPatterns = {"/IncluirCompras"})
public class IncluirCompras extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
       int id_cliente = Integer.parseInt("id_cliente");
       int id_produto= Integer.parseInt("id_produto");

 // ========================================= faz a verificação de dados ============================================       

        try {
            
            request.setAttribute("erro_nome", "");

            if ((id_cliente ) <1 || (id_produto) <1)// verifica os dados
            {  // retorna para o formulario de contato

                if ((id_cliente ) <1 ) {
                    request.setAttribute("erro_id_cliente", "ID cliente informado invalido");
                }

                if ((id_produto ) <1 ) {
                    request.setAttribute("erro_id_produto", "ID produto informado invalido");
                }

// ====================================== se dados errados chama o forms de insere Compras novamente ==========================
                RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
                rd.forward(request, response);
            } else {

                Compras comp = new Compras( id_cliente, id_produto);
                Compras_DAO comp_dao = new Compras_DAO();
                try {
                    comp_dao.Inserir(comp);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
// =========================== se tudo ok chama metodo listar clientes passando para resposta =================================================================================================                    
                    request.setAttribute("retorna", "ListaCompras");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_id_cliente", "ID cliente informado invalido");
            request.setAttribute("erro_id_produto", "ID produto informado invalido");
  //========================= se algum dado estiver errado devolve o form do Compras  ===========================          
            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
            rd.forward(request, response);
        }

    }

}