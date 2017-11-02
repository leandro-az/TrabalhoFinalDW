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
public class Categoria {
    private int id;
    private String descricao;
    
    public Categoria(String desc) {
        this.descricao = desc;
    
     }
    
    public Categoria(int idr, String desc) {
        this.descricao = desc;
        this.id = idr;
    
     }

    public Categoria(int idr) {
        this.id = idr;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDesc() {
        return this.descricao;
    }

    public void setDesc(String desc) {
        this.descricao = desc;
    }
}