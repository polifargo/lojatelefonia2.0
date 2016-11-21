/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.services;

import br.com.lojatelefonia.dao.DaoProduto;
import br.com.lojatelefonia.dao.DaoRelatorio;
import br.com.lojatelefonia.exceptions.DataSourceException;
import br.com.lojatelefonia.exceptions.ProdutoException;

/**
 *
 * @author matheus.esanto1
 */
public class ServiceRelatorio {
        //Excluir Produto
    public static void excliurRelatorio(Integer idRelatorio, Integer option)
            throws ProdutoException, DataSourceException {
        if (idRelatorio != null && option == 0) {
            try {
                //Realiza a exclusão do produto por id
                DaoRelatorio.excluir(idRelatorio);
                return;
            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
    }
    
        //Insere um Produto na fonte de dados
    public static void cadastrarRelatorio(Double valorTotal, String Cliente, Integer qtdItems, String dataVenda)
            throws ProdutoException, DataSourceException {
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoRelatorio.inserir(valorTotal, Cliente, qtdItems, dataVenda);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
