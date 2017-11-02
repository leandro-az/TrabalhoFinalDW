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
public class Compras_DAO {
    public void Inserir(Compras comp) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO COMPRAS (id_cliente,id_produto) VALUES (?,?)");
            sql.setInt(1, comp.getIdcliente());
            sql.setInt(2, comp.getIdproduto());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Compras get(Compras comp) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM COMPRAS WHERE ID = ? ");
            sql.setInt(1, comp.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    comp.setIdcliente(Integer.parseInt(resultado.getString("ID_CLIENTE")));
                    comp.setIdproduto(Integer.parseInt(resultado.getString("ID_PRODUTO")));
                }
            }
            return comp;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Compras comp) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE COMPRAS SET id_cliente = ?, id_produto = ? WHERE ID = ? ");
            sql.setInt(1, comp.getIdcliente());
            sql.setInt(2, comp.getIdproduto());
            sql.setInt(3, comp.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Compras comp) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM COMPRAS WHERE ID = ? ");
            sql.setInt(1, comp.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Compras> Listar() {
        ArrayList<Compras> minhasCompras = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM COMPRAS";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Compras comp;
                    comp = new Compras(Integer.parseInt(resultado.getString("ID")),
                           Integer.parseInt(resultado.getString("ID_CLIENTE"),
                           Integer.parseInt(resultado.getString("ID_PRODUTO"))));
                    minhasCompras.add(comp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return minhasCompras;

    }
    
}
