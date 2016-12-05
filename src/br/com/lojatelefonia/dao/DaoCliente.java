/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.dao;

import br.com.lojatelefonia.db.utils.ConnectionUtils;
import br.com.lojatelefonia.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rafael Ferreira
 */
public class DaoCliente {

    public static void inserir(String nomeCliente, String nascCliente,String telefoneCliente, 
            String ruaCliente,String compCliente, String cepCliente, String numCasaCliente, 
            String emailCliente, String cpfCliente) throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO clientes (nome, nascimento, telefone, rua, complemento, cep, numcasa, email, cpf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            preparedStatement.setString(1, nomeCliente);
            preparedStatement.setString(2, nascCliente);
            preparedStatement.setString(3, telefoneCliente);
            preparedStatement.setString(4, ruaCliente);
            preparedStatement.setString(5, compCliente);
            preparedStatement.setString(6, cepCliente);
            preparedStatement.setString(7, numCasaCliente);
            preparedStatement.setString(8, emailCliente);
            preparedStatement.setString(9, cpfCliente);

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

    public static void atualizar(Integer idCliente, String nomeCliente, String nascCliente, 
            String telefoneCliente, String ruaCliente,String compCliente, String cepCliente, 
            String numCasaCliente, String emailCliente, String cpfCliente) 
            throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando prepared statement
        String sql = "UPDATE clientes SET nome=?, nascimento=?, telefone=?, rua=?, complemento=?, cep=?, "
                + "numcasa=?, email=?, cpf=? WHERE id=?";
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
            preparedStatement.setString(1, nomeCliente);
            preparedStatement.setString(2, nascCliente);
            preparedStatement.setString(3, telefoneCliente);
            preparedStatement.setString(4, ruaCliente);
            preparedStatement.setString(5, compCliente);
            preparedStatement.setString(6, cepCliente);
            preparedStatement.setString(7, numCasaCliente);
            preparedStatement.setString(8, emailCliente);
            preparedStatement.setString(9, cpfCliente);
            preparedStatement.setInt(10, idCliente);

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

    public static void excluir(Integer idCliente) 
            throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando prepared statement
        String sql = "DELETE FROM clientes WHERE id = " + idCliente;
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

    public static ArrayList<Cliente> getListaClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM clientes ORDER BY nome";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Cliente cliente;
            while (rs.next()) {
                cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), 
                        rs.getString("nascimento"), rs.getString("telefone"), 
                        rs.getString("rua"),rs.getString("complemento"), 
                        rs.getString("cep"),rs.getString("numcasa"), 
                        rs.getString("email"), rs.getString("cpf"));
                listaClientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
}
