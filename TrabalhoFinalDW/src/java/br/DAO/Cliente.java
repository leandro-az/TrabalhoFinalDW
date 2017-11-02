package br.DAO;

public class Cliente {

    public Cliente(int id) {
        this.id = id;
    }

    private int id;
    private String nome;
    private int idade;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cpf;
    private String rg;
    private String sexo;
    private String estado_civil;
    private String email;
    private String telefone;
    private String numero_cartao;
    private String bandeira_cartao;
    private String loggin;
    private String senha;
    
    public Cliente(String nome, int idade, String endereco, String bairro, String cidade, String estado, String cpf, String rg, String sexo, String estado_civil, String email, String telefone, String numero_cartao, String bandeira_cartao, String loggin, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
        this.email = email;
        this.telefone = telefone;
        this.numero_cartao = numero_cartao;
        this.bandeira_cartao = bandeira_cartao;
        this.loggin = loggin;
        this.senha = senha;
    }
  
    public Cliente(int id,String nome, int idade, String endereco, String bairro, String cidade, String estado, String cpf, String rg, String sexo, String estado_civil, String email, String telefone, String numero_cartao, String bandeira_cartao, String loggin, String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
        this.email = email;
        this.telefone = telefone;
        this.numero_cartao = numero_cartao;
        this.bandeira_cartao = bandeira_cartao;
        this.loggin = loggin;
        this.senha = senha;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the estado_civil
     */
    public String getEstado_civil() {
        return estado_civil;
    }

    /**
     * @param estado_civil the estado_civil to set
     */
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the numero_cartao
     */
    public String getNumero_cartao() {
        return numero_cartao;
    }

    /**
     * @param numero_cartao the numero_cartao to set
     */
    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    /**
     * @return the bandeira_cartao
     */
    public String getBandeira_cartao() {
        return bandeira_cartao;
    }

    /**
     * @param bandeira_cartao the bandeira_cartao to set
     */
    public void setBandeira_cartao(String bandeira_cartao) {
        this.bandeira_cartao = bandeira_cartao;
    }

    /**
     * @return the loggin
     */
    public String getLoggin() {
        return loggin;
    }

    /**
     * @param loggin the loggin to set
     */
    public void setLoggin(String loggin) {
        this.loggin = loggin;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
