/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

/**
 *
 * @author leandroall
 */
public class Produto {

    private int id;
    private String nome;
    private int id_categoria;
    private String descricao;
    private double valor;

    public Produto(String desc, int idcat,double val,String name) {
        this.nome=name;
        this.descricao = desc;
        this.id_categoria = idcat;
        this.valor = val;
    }
    
     public Produto(int idr , String desc, int idcat,double val, String name) {
        this.id=idr;
        this.nome=name;
        this.descricao = desc;
        this.id_categoria = idcat;
        this.valor = val;
    }

    public Produto(int idr) {
        this.id =idr;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdcat() {
        return id_categoria;
    }

    public void setIdcat(int id) {
        this.id_categoria = id;
    }

    public String getDesc() {
        return this.descricao;
    }

    public void setDesc(String desc) {
        this.descricao = desc;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double val) {
        this.valor = val;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
