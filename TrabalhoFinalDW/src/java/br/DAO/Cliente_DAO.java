/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente_DAO {

    public void Inserir(Cliente contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CLIENTE ( nome, idade, endereco, bairro,  cidade, estado, cpf, rg, sexo, estado_civil, email, telefone, numero_cartao, bandeira_cartao, loggin, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sql.setString(1, contato.getNome());
            sql.setInt(2, contato.getIdade());
            sql.setString(3, contato.getEndereco());
            sql.setString(4, contato.getBairro());
            sql.setString(5, contato.getCidade());
            sql.setString(6, contato.getEstado());
            sql.setString(7, contato.getCpf());
            sql.setString(8, contato.getRg());
            sql.setString(9, contato.getSexo());
            sql.setString(10, contato.getEstado_civil());
            sql.setString(11, contato.getEmail());
            sql.setString(12, contato.getTelefone());
            sql.setString(13, contato.getNumero_cartao());
            sql.setString(14, contato.getBandeira_cartao());
            sql.setString(15, contato.getLoggin());
            sql.setString(16, contato.getSenha());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Cliente get(Cliente contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CLIENTE WHERE ID = ? ");
            sql.setInt(1, contato.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    contato.setNome(resultado.getString("NOME"));
                    contato.setIdade(Integer.parseInt(resultado.getString("IDADE")));
                }
            }
            return contato;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Cliente contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CLIENTE SET nome= ?, idade= ?, endereco= ?, bairro= ?,  cidade= ?, estado= ?, cpf= ?, rg= ?, sexo= ?, estado_civil= ?, email= ?, telefone= ?, numero_cartao= ?, bandeira_cartao= ?, loggin= ?, senha= ?  WHERE ID = ? ");
            sql.setString(1, contato.getNome());
            sql.setInt(2, contato.getIdade());
            sql.setString(3, contato.getEndereco());
            sql.setString(4, contato.getBairro());
            sql.setString(5, contato.getCidade());
            sql.setString(6, contato.getEstado());
            sql.setString(7, contato.getCpf());
            sql.setString(8, contato.getRg());
            sql.setString(9, contato.getSexo());
            sql.setString(10, contato.getEstado_civil());
            sql.setString(11, contato.getEmail());
            sql.setString(12, contato.getTelefone());
            sql.setString(13, contato.getNumero_cartao());
            sql.setString(14, contato.getBandeira_cartao());
            sql.setString(15, contato.getLoggin());
            sql.setString(16, contato.getSenha());
            sql.setInt(17, contato.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Cliente contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CLIENTE WHERE ID = ? ");
            sql.setInt(1, contato.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Cliente> Listar() {
        ArrayList<Cliente> meusContatos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CLIENTE";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Cliente contato;
                    contato = new Cliente(Integer.parseInt(resultado.getString("id")),
                            resultado.getString("NOME"),
                            Integer.parseInt(resultado.getString("IDADE")),
                            resultado.getString("ENDERECO"),
                            resultado.getString("BAIRRO"),
                            resultado.getString("CIDADE"),
                            resultado.getString("ESTADO"),
                            resultado.getString("CPF"),
                            resultado.getString("RG"),
                            resultado.getString("SEXO"),
                            resultado.getString("ESTADO_CIVIL"),
                            resultado.getString("EMAIL"),
                            resultado.getString("TELEFONE"),
                            resultado.getString("NUMERO_CARTAO"),
                            resultado.getString("BANDEIRA_CARTAO"),
                            resultado.getString("LOGGIN"),
                            resultado.getString("SENHA"));
                    meusContatos.add(contato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusContatos;

    }

}
