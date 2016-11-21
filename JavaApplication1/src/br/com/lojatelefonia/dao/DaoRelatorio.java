/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.dao;

import br.com.lojatelefonia.db.utils.ConnectionUtils;
import br.com.lojatelefonia.models.Relatorio;
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
public class DaoRelatorio {

    public static void inserir(Double valorTotal, String Cliente, Integer qtdItems, String dataVenda)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD, utilizando os dados do produtos passados como parâmetro
        String sql = "INSERT INTO relatorio (valor_total, cliente, qtd_items, data_venda) "
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
            preparedStatement.setDouble(1, valorTotal);
            preparedStatement.setString(2, Cliente);
            preparedStatement.setInt(3, qtdItems);
            preparedStatement.setString(4, dataVenda);

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

    public static void excluir(Integer idRelatorio) throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando prepared statement
        String sql = "DELETE FROM relatorio WHERE id_venda = " + idRelatorio;
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

    public static ArrayList<Relatorio> getListaRelatorio(String data) {
        ArrayList<Relatorio> listaRelatorio = new ArrayList<Relatorio>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM RELATORIO "
                + "WHERE DATA_VENDA = '" + data + "'";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Relatorio relatorio;
            while (rs.next()) {
                relatorio = new Relatorio(rs.getInt("id_venda"), rs.getDouble("valor_total"), rs.getInt("qtd_items"),
                        rs.getString("cliente"), rs.getString("data_venda"));
                listaRelatorio.add(relatorio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRelatorio;
    }
}
