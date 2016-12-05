/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.dao;

import br.com.lojatelefonia.db.utils.ConnectionUtils;
import br.com.lojatelefonia.models.ModeloVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author matheus.esanto1
 */
public class DaoVenda {

    public static void inserir(Double valorUniProduto, Double valorProduto, String nomeProduto, int qtdProduto)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD, utilizando os dados do produtos passados como parâmetro
        String sql = "INSERT INTO venda (valoruni, valor, produto, qtd) "
                + "VALUES (?, ?, ?, ?)";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setDouble(1, valorUniProduto);
            preparedStatement.setDouble(2, valorProduto);
            preparedStatement.setString(3, nomeProduto);
            preparedStatement.setInt(4, qtdProduto);
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void excluirCarrinho() 
            throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando prepared statement
        String sql = "DELETE FROM venda";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void atualizarProduto(Integer idVenda, Integer qtdProduto) 
            throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando prepared statement
        String sql = "UPDATE produtos SET qtd = ? WHERE id = ?";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, qtdProduto);
            preparedStatement.setInt(2, idVenda);
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    //Pegar tabela de venda
    public static ArrayList<ModeloVenda> getListaVendas() {
        ArrayList<ModeloVenda> listaVendas = new ArrayList<ModeloVenda>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM venda";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            ModeloVenda venda;
            while (rs.next()) {
                venda = new ModeloVenda(rs.getInt("idcarrinho"), rs.getDouble("valoruni"), 
                        rs.getDouble("valor"), rs.getString("produto"), rs.getInt("qtd"));
                listaVendas.add(venda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVendas;
    }
}
