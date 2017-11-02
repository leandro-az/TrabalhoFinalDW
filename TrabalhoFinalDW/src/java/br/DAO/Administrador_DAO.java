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
public class Administrador_DAO {
    
    
    
    public void Inserir(Administrador adm) throws Exception {
        Conexao conexao = new Conexao();
         try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO ADMINISTRADOR (nome,loggin,senha) VALUES (?,?,?)");
            sql.setString(1, adm.getNome());
            sql.setString(2, adm.getLoggin());
            sql.setString(3, adm.getSenha());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Administrador get(Administrador adm) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE ID = ? ");
            sql.setInt(1, adm.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    adm.setNome(resultado.getString("NOME"));
                    adm.setLoggin(resultado.getString("LOGGIN"));
                    adm.setSenha(resultado.getString("SENHA"));
                }
            }
            return adm;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Administrador adm) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE ADMINISTRADOR SET nome = ?, loggin= ?, senha =? WHERE ID = ? ");
            sql.setString(1, adm.getNome());
            sql.setString(2, adm.getLoggin());
            sql.setString(3, adm.getSenha());
            sql.setInt(4, adm.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Administrador adm) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM ADMINISTRADOR WHERE ID = ? ");
            sql.setInt(1, adm.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Administrador> Listar() {
        ArrayList<Administrador> meusADM = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM ADMINISTRADOR";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Administrador adm;
                    adm = new Administrador(Integer.parseInt(resultado.getString("ID")),
                            resultado.getString("NOME"),resultado.getString("LOGGIN"),resultado.getString("SENHA"));
                    meusADM.add(adm);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusADM;

    }
    
}
