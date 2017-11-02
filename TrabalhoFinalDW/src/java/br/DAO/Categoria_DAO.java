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
public class Categoria_DAO {
    
    public void Inserir(Categoria cat) throws Exception {
        Conexao conexao = new Conexao();
         try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CATEGORIA (descricao) VALUES (?)");
            sql.setString(1, cat.getDesc());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Categoria get(Categoria cat) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CATEGORIA WHERE ID = ? ");
            sql.setInt(1, cat.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    cat.setDesc(resultado.getString("DESCRICAO"));
                }
            }
            return cat;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Categoria cat) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CATEGORIA SET descricao = ? WHERE ID = ? ");
            sql.setString(1, cat.getDesc());
            sql.setInt(2, cat.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Categoria cat) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CATEGORIA WHERE ID = ? ");
            sql.setInt(1, cat.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Categoria> Listar() {
        ArrayList<Categoria> minhasCateg = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CATEGORIA";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Categoria cat;
                    cat = new Categoria(Integer.parseInt(resultado.getString("ID")),
                            resultado.getString("DESCRICAO"));
                    minhasCateg.add(cat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return minhasCateg;

    }
    
}
    

