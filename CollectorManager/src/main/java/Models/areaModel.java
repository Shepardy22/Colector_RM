/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuri
 */


public class areaModel {

    private Connection connection;
    private Statement statement;

    public areaModel() {
        String url = "jdbc:sqlite:data/database.db";

        try {
            this.connection = DriverManager.getConnection(url);
            System.out.println("Conexão com o banco de dados estabelecida.");

            //cria o objeto Statement para execução de queries
            this.statement = connection.createStatement();

        } catch (SQLException ex) {
            System.out.println("Erro:..." + ex.getMessage());
        }

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

    public boolean createTable(String nomeTabela) {
        try {
            // cria uma tabela no banco de dados
            String sql = "CREATE TABLE IF NOT EXISTS " + nomeTabela + "(\n"
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + " barcode TEXT NOT NULL,\n"
                    + " quantidade INTEGER\n"
                    + ");";
            this.statement.execute(sql);

            System.out.println("Tabela " + nomeTabela + " com sucesso.");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return true;
    }

    public boolean insertData(String nomeTabela, String barcode, int quantidade) {
        try {
            String sql = "INSERT INTO " + nomeTabela + "(barcode, quantidade) VALUES(?,?)";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, barcode);
            pstmt.setInt(2, quantidade);
            pstmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso.");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        
    }

    public boolean updateData(String nomeTabela, int id, String barcode, int quantidade) {
        try {
            String sql = "UPDATE " + nomeTabela + " SET barcode=?, quantidade=? WHERE id=?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, barcode);
            pstmt.setInt(2, quantidade);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso.");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public Area retrieveData(String nomeTabela) {
        Area area = new Area();
        area.setNome(nomeTabela);
        try {
            String sql = "SELECT * FROM " + nomeTabela;
            ResultSet rs = this.statement.executeQuery(sql);
            while (rs.next()) {
                String barcode = rs.getString("barcode");
                int quantidade = rs.getInt("quantidade");
                area.adicionarProduto(barcode, quantidade);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return area;
    }

    public boolean deleteTable(String nomeTabela) {
        try {
            String sql = "DROP TABLE IF EXISTS" + nomeTabela + "";
            this.statement.execute(sql);
            System.out.println("Tabela deletada com sucesso.");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    

}
