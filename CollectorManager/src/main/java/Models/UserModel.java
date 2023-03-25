/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class UserModel {

    private Connection connection;
    private Statement statement;

    public void connect() {
        String url = "jdbc:sqlite:data/database.db";
        try {
            //cria a conexão com o banco de dados
            this.connection = DriverManager.getConnection(url);
            System.out.println("Conexão com o banco de dados estabelecida.");

            //cria o objeto Statement para execução de queries
            this.statement = this.connection.createStatement();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
       
    }
    
    public UserModel(){
        connect();
    }

    public void disconnect() {
        try {
            //fecha a conexão com o banco de dados
            this.connection.close();
            System.out.println("Conexão com o banco de dados fechada.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    public void createTable() {
        try {
            //cria uma tabela no banco de dados
            String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " nome text NOT NULL,\n"
                    + " senha integer\n"
                    + ");";
            this.statement.execute(sql);

            System.out.println("Tabela criada com sucesso.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

    public void insertData(int id, String nome, int senha) {
        try {
            //insere dados na tabela
            String sql = "INSERT INTO usuarios(id, nome, senha) VALUES(?, ?, ?);";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nome);
            pstmt.setInt(3, senha);
            pstmt.executeUpdate();

            System.out.println("Dados inseridos com sucesso.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

    public void updateData(int id, String nome, int senha) {
        try {
            //atualiza dados na tabela
            String sql = "UPDATE usuarios SET nome = ?, senha = ? WHERE id = ?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setInt(2, senha);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();

            System.out.println("Dados atualizados com sucesso.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
    }


    public void retrieveData() {
        try {
            // executa uma query para recuperar os dados da tabela
            String sql = "SELECT id, nome, senha FROM usuarios;";
            // percorre os resultados da query e imprime na tela
            try (ResultSet rs = this.statement.executeQuery(sql)) {
                // percorre os resultados da query e imprime na tela
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int senha = rs.getInt("senha");
                    System.out.println("ID: " + id + " | Nome: " + nome + " | senha: " + senha);
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
