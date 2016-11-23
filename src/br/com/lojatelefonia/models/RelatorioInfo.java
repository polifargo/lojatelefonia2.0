package br.com.lojatelefonia.models;

public class RelatorioInfo {

    private String produto;
    private int qtd;
    private double valor;

    public RelatorioInfo(String produto, int qtd, double valor) {
        this.produto = produto;
        this.qtd = qtd;
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public int getQtd() {
        return qtd;
    }

    public double getValor() {
        return valor;
    }
}
