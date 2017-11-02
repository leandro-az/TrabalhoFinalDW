/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CREATE TABLE CONTATO (
//    id INT not null primary key
//        GENERATED ALWAYS AS IDENTITY
//        (START WITH 1, INCREMENT BY 1), 
//    nome varchar(20),
//    idade integer
//
//);
public class Conexao {

//    private String DRIVE = "rg.apache.derby.jdbc.ClientDriver";
//    private String URL = "jdbc:derby://localhost:1527/trabalhodw";
//    private String user = "adm";
//    private String password = "adm";
    private Connection conexao;

    public Conexao() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");//load driver
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/trabalhodw", "adm", "adm");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Nao foi possivel efetuar uma conexao com o BD!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Nao foi possivel encontrar a classe referente! Verifique o driver!");
        }
    }
    
    public Connection getConexao(){
        return this.conexao;
    }
    
    public void closeConexao(){
        try {
            this.conexao.commit();
            this.conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

 
}
