/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.services;

import br.com.lojatelefonia.dao.DaoCliente;
import br.com.lojatelefonia.exceptions.ClienteException;
import br.com.lojatelefonia.exceptions.DataSourceException;

/**
 *
 * @author Rafael Ferreira
 */
public class ServiceCliente {

    //Insere um cliente na fonte de dados
    public static void cadastrarCliente(String nomeCliente, String nascCliente,
            String telefoneCliente, String endCliente, String emailCliente, String cpfCliente) throws ClienteException, DataSourceException {
        //Realização de validações de negócio
        if ("".equals(nomeCliente) || "  /  /    ".equals(nascCliente)
                || "(  )    -    ".equals(telefoneCliente) || "   .   .   -  ".equals(cpfCliente) || "".equals(endCliente)) {
            throw new ClienteException("Um ou mais campos estão vazios, convém preenche-los!");
        } else if (!emailCliente.contains("@") && !emailCliente.contains(".")) {
            throw new ClienteException("E-mail incorreto!");
        }
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoCliente.inserir(nomeCliente, nascCliente, telefoneCliente, endCliente, emailCliente, cpfCliente);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um cliente na fonte de dados
    public static void atualizarCliente(Integer idCliente, String nomeCliente, String nascCliente,
            String telefoneCliente, String endCliente, String emailCliente, String cpfCliente) throws ClienteException, DataSourceException {
        //Realização de validações de negócio
        if ("".equals(nomeCliente) || "  /  /    ".equals(nascCliente)
                || "(  )    -    ".equals(telefoneCliente) || "   .   .   -  ".equals(cpfCliente) || "".equals(endCliente)) {
            throw new ClienteException("Um ou mais campos estão vazios, convém preenche-los!");
        } else if (!emailCliente.contains("@") && !emailCliente.contains(".")) {
            throw new ClienteException("E-mail incorreto!");
        }
        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoCliente.atualizar(idCliente, nomeCliente, nascCliente, telefoneCliente, endCliente, emailCliente, cpfCliente);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Excluir cliente
    public static void excliurCliente(Integer idCliente, Integer option)
            throws ClienteException, DataSourceException {
        if (idCliente != null && option == 0) {
            try {
                //Realiza a exclusão do cliente por id
                DaoCliente.excluir(idCliente);
                return;
            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
    }
}
