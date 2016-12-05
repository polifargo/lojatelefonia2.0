package br.com.lojatelefonia.models;

public class Cliente {

    private int id;
    private String nome;
    private String nasc;
    private String telefone;
    private String rua;
    private String complemento;
    private String cep;
    private String numCasa;
    private String email;
    private String cpf;

    public Cliente(Integer id, String nome, String nasc, String telefone, String rua, String complemento, String cep, String numCasa, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.nasc = nasc;
        this.telefone = telefone;
        this.rua = rua;
        this.complemento = complemento;
        this.cep = cep;
        this.numCasa = numCasa;
        this.email = email;
        this.cpf = cpf;
    }
    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNasc() {
        return nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getRua() {
        return rua;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public String getCep() {
        return cep;
    }
    
    public String getNumCasa() {
        return numCasa;
    }

    public String getEmail() {
        return email;
    }
    
    public String getCpf() {
        return cpf;
    }

}
