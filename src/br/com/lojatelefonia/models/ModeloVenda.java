package br.com.lojatelefonia.models;

public class ModeloVenda {

    int idVenda;
    double valorUni;
    double valorVenda;
    String produto;
    int qtd;

    public ModeloVenda(int idVenda, Double valorUni, Double valorVenda, String produto, int qtd) {
        this.idVenda = idVenda;
        this.valorUni = valorUni;
        this.valorVenda = valorVenda;
        this.produto = produto;
        this.qtd = qtd;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public String getProduto() {
        return produto;
    }

    public int getQtd() {
        return qtd;
    }

    public double getValorUni() {
        return valorUni;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }

}
