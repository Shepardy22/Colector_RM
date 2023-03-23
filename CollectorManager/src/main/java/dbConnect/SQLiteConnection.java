/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {
    
    private Connection connection;
    private Statement statement;
    
    public boolean connect(){
        String url = "jdbc:sqlite:data/database.db";
        try{
            //cria a conexão com o banco de dados
            this.connection = DriverManager.getConnection(url);
            System.out.println("Conexão com o banco de dados estabelecida.");
            
            //cria o objeto Statement para execução de queries
            this.statement = this.connection.createStatement();
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean disconnect(){
        try{
            //fecha a conexão com o banco de dados
            this.connection.close();
            System.out.println("Conexão com o banco de dados fechada.");
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean createTable(){
        try{
            //cria uma tabela no banco de dados
            String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " nome text NOT NULL,\n"
                    + " idade integer\n"
                    + ");";
            this.statement.execute(sql);
            
            System.out.println("Tabela criada com sucesso.");
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean insertData(){
        try{
            //insere dados na tabela
            String sql = "INSERT INTO usuarios(id, nome, idade) VALUES(1, 'João', 25);";
            this.statement.executeUpdate(sql);
            
            System.out.println("Dados inseridos com sucesso.");
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    
}