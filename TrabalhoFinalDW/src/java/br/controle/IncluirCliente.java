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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirCliente", urlPatterns = {"/IncluirCliente"})
public class IncluirCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String endereco= request.getParameter("endereco");
        String bairro= request.getParameter("bairro");
        String cidade= request.getParameter("cidade");
        String estado= request.getParameter("estado");
        String cpf= request.getParameter("cpf");
        String rg= request.getParameter("rg");
        String sexo= request.getParameter("sexo");
        String estado_civil= request.getParameter("estado_civil");
        String email= request.getParameter("email");
        String telefone= request.getParameter("telefone");
        String numero_cartao= request.getParameter("numero_cartao");
        String bandeira_cartao= request.getParameter("bandeira_cartao");
        String loggin= request.getParameter("loggin");
        String senha= request.getParameter("senha");

 // ========================================= faz a verificação de dados ============================================       

        try {
            
            request.setAttribute("erro_nome", "");

            if ((idade < 18) || (nome.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (idade < 18) {
                    request.setAttribute("erro_idade", "A idade não pode ser menor que 18");
                }

                RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
                rd.forward(request, response);
            } else {

              Cliente contato = new Cliente( nome, idade, endereco, bairro,  cidade, estado, cpf, rg, sexo, estado_civil, email, telefone, numero_cartao, bandeira_cartao, loggin, senha);
                Cliente_DAO cliente_dao = new Cliente_DAO();
                try {
                    cliente_dao.Inserir(contato);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
// =========================== se tudo ok chama metodo listar clientes passando para resposta =================================================================================================                    
                    request.setAttribute("retorna", "ListaCliente");
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
  //========================= se algum dado estiver errado devolve ===========================          
            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
            rd.forward(request, response);
        }

    }

}
