/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.services;

import br.com.lojatelefonia.dao.DaoVenda;
import br.com.lojatelefonia.exceptions.DataSourceException;
import br.com.lojatelefonia.exceptions.ProdutoException;

/**
 *
 * @author matheus.esanto1
 */
public class ServiceVenda {

    //Insere um Produto na fonte de dados
    public static void cadastrarProduto(Double valorTotal, String nomeProduto, int qtdProduto)
            throws ProdutoException, DataSourceException {
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoVenda.inserir(valorTotal, nomeProduto, qtdProduto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Excluir Produto Quantidade
    public static void excliurProdutoQuantidade(Integer idVenda, Integer qtdProduto, Integer option)
            throws ProdutoException, DataSourceException {
        if (idVenda != null && option == 0) {
            try {
                //Realiza a exclusão do produto por id
                DaoVenda.excluirQuantidade(idVenda, qtdProduto);
                return;
            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
    }
    
        //Excluir Produto 
    public static void excliurProduto(Integer idVenda, Integer option)
            throws ProdutoException, DataSourceException {
        if (idVenda != null && option == 0) {
            try {
                //Realiza a exclusão do produto por id
                DaoVenda.excluir(idVenda);
                return;
            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
    }

    //Deletar o carrinho
    public static void excluirCarrinho()
            throws ProdutoException, DataSourceException {
        try {
            //Realiza a exclusão do produto por id
            DaoVenda.excluirCarrinho();
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
