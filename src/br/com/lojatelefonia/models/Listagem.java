package br.com.lojatelefonia.models;

public class Listagem {

    private int idlistagem;
    private double valorfinal;
    private int qtd;
    private String cliente;
    private String dataVenda;

    public Listagem(int idlistagem, double valorfinal, int qtd, String cliente, String dataVenda) {
        this.idlistagem = idlistagem;
        this.valorfinal = valorfinal;
        this.qtd = qtd;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public int getIdListagem() {
        return idlistagem;
    }

    public double getValorfinal() {
        return valorfinal;
    }

    public int getQtd() {
        return qtd;
    }

    public String getCliente() {
        return cliente;
    }

}
