/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Administrador;
import br.DAO.Administrador_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Incluir", urlPatterns = {"/Incluir"})
public class IncluirADM extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String loggin= request.getParameter("loggin");
        String senha= request.getParameter("senha");

 // ========================================= faz a verificação de dados ============================================       

        try {
            
            request.setAttribute("erro_nome", "");

            if ((senha.isEmpty() ) || (nome.isEmpty()) || (loggin.isEmpty()) )// verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (senha.isEmpty()) {
                    request.setAttribute("erro_senha", "A senha não pode ser vazia");
                }
                
                 if (senha.isEmpty()) {
                    request.setAttribute("erro_loggin", "o loggin não pode ser vazia");
                }
// ====================================== se dados errados chama o forms de insere ADM novamente ==========================
                RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
                rd.forward(request, response);
            } else {

              Administrador adm = new Administrador( nome, loggin, senha);
                Administrador_DAO adm_dao = new Administrador_DAO();
                try {
                    adm_dao.Inserir(adm);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
// =========================== se tudo ok chama metodo listar clientes passando para resposta =================================================================================================                    
                    request.setAttribute("retorna", "ListaADM");
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