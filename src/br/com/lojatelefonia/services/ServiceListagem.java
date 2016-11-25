/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.services;

import br.com.lojatelefonia.dao.DaoListagem;
import br.com.lojatelefonia.exceptions.DataSourceException;
import br.com.lojatelefonia.exceptions.ProdutoException;

/**
 *
 * @author matheus.esanto1
 */
public class ServiceListagem {

    //Excluir Produto
    public static void excliurListagem(Integer idListagem, Integer option)
            throws ProdutoException, DataSourceException {
        if (idListagem != null && option == 0) {
            try {
                //Realiza a exclusão do produto por id
                DaoListagem.excluir(idListagem);
                return;
            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
    }

    //Insere um Produto na fonte de dados
    public static void cadastrarListagem(Double valorTotal, String Cliente, Integer qtdItems, String dataVenda)
            throws ProdutoException, DataSourceException {
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoListagem.inserir(valorTotal, Cliente, qtdItems, dataVenda);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
