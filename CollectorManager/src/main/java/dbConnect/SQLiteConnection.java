/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {

    private Connection connection;
    private Statement statement;

    public boolean connect() {
        String url = "jdbc:sqlite:data/database.db";
        try {
            //cria a conexão com o banco de dados
            this.connection = DriverManager.getConnection(url);
            System.out.println("Conexão com o banco de dados estabelecida.");

            //cria o objeto Statement para execução de queries
            this.statement = this.connection.createStatement();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean disconnect() {
        try {
            //fecha a conexão com o banco de dados
            this.connection.close();
            System.out.println("Conexão com o banco de dados fechada.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean createTable() {
        try {
            //cria uma tabela no banco de dados
            String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " nome text NOT NULL,\n"
                    + " idade integer\n"
                    + ");";
            this.statement.execute(sql);

            System.out.println("Tabela criada com sucesso.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean insertData() {
        try {
            //insere dados na tabela
            String sql = "INSERT INTO usuarios(id, nome, idade) VALUES(2, 'pedro', 32);";
            this.statement.executeUpdate(sql);

            System.out.println("Dados inseridos com sucesso.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateData(int id, String nome, int idade) {
        try {
            //atualiza dados na tabela
            String sql = "UPDATE usuarios SET nome = '" + nome + "', idade = " + idade + " WHERE id = " + id + ";";
            this.statement.executeUpdate(sql);

            System.out.println("Dados atualizados com sucesso.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public void retrieveData() {
        try {
            // executa uma query para recuperar os dados da tabela
            String sql = "SELECT id, nome, idade FROM usuarios;";
            // percorre os resultados da query e imprime na tela
            try (ResultSet rs = this.statement.executeQuery(sql)) {
                // percorre os resultados da query e imprime na tela
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    System.out.println("ID: " + id + " | Nome: " + nome + " | Idade: " + idade);
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
