/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Cliente;
import br.DAO.Cliente_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo
 */
@WebServlet(name = "EditarCliente", urlPatterns = {"/EditarCliente"})
public class EditarCliente extends HttpServlet {
// ==================================  estra aqui depois de ter listado os clientes logo ja possui o id dele ========================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cli = new Cliente(id);
        Cliente_DAO contato_dao = new Cliente_DAO();
        try {
            contato_dao.get(cli);
            request.setAttribute("cliente", cli);
// =========================================== Aqui chama o forms de edição do Cliente fazer a troca =================================
            RequestDispatcher rd = request.getRequestDispatcher("Form_Cliente_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idade = Integer.parseInt(request.getParameter("idade"));
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
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

        Cliente contato = new Cliente(id, nome, idade, endereco, bairro,  cidade, estado, cpf, rg, sexo, estado_civil, email, telefone, numero_cartao, bandeira_cartao, loggin, senha);

//  ======================================  Aqui faz a verificacao se os dados passados para a alteracao estao corretos se algum dado estuver errado devolve ==========================================================================        
        
        try {
            if ((idade < 18) || (nome.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (idade < 18) {
                    request.setAttribute("erro_idade", "A idade não pode ser menor que 18");
                }

//========================= se algum dado estiver errado devolve ===========================

                request.setAttribute("contato", contato);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Contato_Editar.jsp");
                rd.forward(request, response);
            } else {
//========================= se não tiver dados errados chama o altera e retorna para listarClientes ===========================
                Cliente_DAO contato_dao = new Cliente_DAO();
                try {
                    contato_dao.Alterar(contato);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
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
            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
            rd.forward(request, response);
        }

    }

}
