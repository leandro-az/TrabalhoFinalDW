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

/**
 *
 * @author leandroall
 */
public class Produto_DAO {
    
    public void Inserir(Produto prod) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO PRODUTO (nome, descricao,valor,id_categoria) VALUES (?,?,?,?)");
            sql.setString(1, prod.getNome());
            sql.setString(2, prod.getDesc());
            sql.setDouble(3, prod.getValor());
            sql.setInt(4, prod.getIdcat());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Produto get(Produto prod) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE ID = ? ");
            sql.setInt(1, prod.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    prod.setNome(resultado.getString("NOME"));
                    prod.setDesc(resultado.getString("DESCRICAO"));
                    prod.setValor(Double.parseDouble(resultado.getString("VALOR")));
                    prod.setIdcat(Integer.parseInt(resultado.getString("ID_CATEGORIA")));
                }
            }
            return prod;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Produto prod) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE PRODUTO SET nome = ?, descricao = ?, valor = ?, id_categoria= ? WHERE ID = ? ");
            sql.setString(1, prod.getNome());
            sql.setString(2, prod.getDesc());
            sql.setDouble(3, prod.getValor());
            sql.setInt(4, prod.getIdcat());
            sql.setInt(5, prod.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Produto prod) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM PRODUTO WHERE ID = ? ");
            sql.setInt(1, prod.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Produto> Listar() {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto prod;
                    prod = new Produto(Integer.parseInt(resultado.getString("ID")),
                            resultado.getString("DESCRICAO"),
                            Integer.parseInt(resultado.getString("ID_CATEGORIA")),
                            Double.parseDouble(resultado.getString("VALOR")),
                            resultado.getString("NOME"));
                    meusProdutos.add(prod);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }
    
}
