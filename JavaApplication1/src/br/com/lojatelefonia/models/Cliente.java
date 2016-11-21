package br.com.lojatelefonia.models;

public class Cliente {

    private int id;
    private String nome;
    private String nasc;
    private String telefone;
    private String end;
    private String email;
    private String cpf;

    public Cliente(Integer id, String nome, String nasc, String telefone, String end, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.nasc = nasc;
        this.telefone = telefone;
        this.end = end;
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

    public String getEnd() {
        return end;
    }

    public String getEmail() {
        return email;
    }
    
    public String getCpf() {
        return cpf;
    }

}
