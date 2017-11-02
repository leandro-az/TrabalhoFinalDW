
import br.DAO.*;
import java.io.PrintStream;
import java.util.logging.Level;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leandroall
 */
public class TesteInsere {
    
    public static void main(String[] args) {
        Categoria cat = new Categoria("Informatica");
        Categoria_DAO cat_dao = new Categoria_DAO();
        
        Administrador adm = new Administrador("Fulano", "adm", "123456");
        Administrador_DAO adm_dao = new Administrador_DAO();
        
        Cliente cli = new Cliente("Fulano", 22, "Rua Judith", "Boassu", "SG", "RJ", "11111", "2222222", "M", "S", "sssss", "333", "444", "A", "ass", "assss");
        Cliente_DAO cli_dado = new Cliente_DAO();
        
        
        
        try {
            /*System.out.println("========= Insere a categoria =====");
            cat_dao.Inserir(cat);
            System.out.println("========= Insere a Produto =====");
            Produto prod = new Produto("coreI7",1 , 2553.20, "Notebook");
            Produto_DAO proddao = new Produto_DAO();
            proddao.Inserir(prod);
            System.out.println("========= Insere O ADM  =====");
            adm_dao.Inserir(adm);
            System.out.println("========= Insere o cliente =====");
            cli_dado.Inserir(cli);
             System.out.println("========= Insere o Compras =====");
            Compras comp = new Compras(6, 8);
            Compras_DAO compdado = new Compras_DAO();
            compdado.Inserir(comp);
            */
            System.out.println("=============== Exclui compra =========");
            Compras comp = new Compras(6, 8);
            Compras_DAO compdado = new Compras_DAO();
            comp.setId(5);
            compdado.Excluir(comp);
            
            System.out.println("=============== Exclui ccliente =========");
            cli.setId(6);
            cli_dado.Excluir(cli);
            
            System.out.println("=============== Exclui produto =========");
             Produto prod = new Produto("coreI7",1 , 2553.20, "Notebook");
            Produto_DAO proddao = new Produto_DAO();
            prod.setId(4);
            proddao.Excluir(prod);
            
            System.out.println("=============== Exclui Categoria =========");
            cat.setId(4);
            cat_dao.Excluir(cat);
            
            System.out.println("=============== Exclui ADM =========");
            adm.setId(4);
            adm_dao.Excluir(adm);
            
            
            
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
}
