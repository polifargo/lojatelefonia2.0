/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.services;

import br.com.lojatelefonia.dao.DaoProduto;
import br.com.lojatelefonia.exceptions.DataSourceException;
import br.com.lojatelefonia.exceptions.ProdutoException;

/**
 *
 * @author Rafael Ferreira
 */
public class ServiceProduto {

    //Insere um Produto na fonte de dados
    public static void cadastrarProduto(String nomeProduto, String descProduto, String marcaProduto,
            String numProduto, String fabriProduto, Integer qtdProduto, Double valorProduto)
            throws ProdutoException, DataSourceException {
        //Realização de validações de negócio
        if ("".equals(nomeProduto) || "".equals(marcaProduto)
                || "".equals(numProduto) || "  /  /    ".equals(fabriProduto)
                || qtdProduto <= 0 || valorProduto <= 0) {
            throw new ProdutoException("Um ou mais campos estão vazios, convém preenche-los!");
        } else if ("Selecione...".equals(descProduto)) {
            throw new ProdutoException("Descrição do item não definida");
        } else if (nomeProduto.length() > 255 || descProduto.length() > 255 
                || marcaProduto.length() > 50 || qtdProduto.toString().length() > 10) {
            throw new ProdutoException("Limite de tamanho ultrapassado!");
        }
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoProduto.inserir(nomeProduto, descProduto, marcaProduto, numProduto, fabriProduto, qtdProduto, valorProduto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um Produto na fonte de dados
    public static void atualizarProduto(Integer idProduto, String nomeProduto, String descProduto,
            String marcaProduto, String numProduto, String fabriProduto, Integer qtdProduto,
            Double valorProduto) throws ProdutoException, DataSourceException {
        //Realização de validações de negócio
        if ("".equals(nomeProduto) || "".equals(marcaProduto)
                || "".equals(numProduto) || "  /  /    ".equals(fabriProduto)
                || qtdProduto == null || valorProduto == null) {
            throw new ProdutoException("Um ou mais campos estão vazios, convém preenche-los!");
        } else if ("Selecione...".equals(descProduto)) {
            throw new ProdutoException("Descrição do item não definida");
        }
        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoProduto.atualizar(idProduto, nomeProduto, descProduto, marcaProduto, numProduto, fabriProduto, qtdProduto, valorProduto);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Excluir Produto
    public static void excliurProduto(Integer idProduto, Integer option)
            throws ProdutoException, DataSourceException {
        if (idProduto != null && option == 0) {
            try {
                //Realiza a exclusão do produto por id
                DaoProduto.excluir(idProduto);
                return;
            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
    }

    //Atualiza Estoqeu Produto
    public static void atualizarProdutoEstoque(Integer idProduto, Integer qtd)
            throws ProdutoException, DataSourceException {
        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoProduto.atualizarEstoque(idProduto, qtd);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
