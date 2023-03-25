/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yuri
 */
public class Area {

    private int id;
    private String nome;
    private Map<String, Integer> produtos;
    public Area() {
        this.produtos = new HashMap<>();
    }

    public Area(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(String barcode, int quantidade) {
        produtos.put(barcode, quantidade);
    }

    public void setProductCount(int productCount) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Map<String, Integer> getProdutos() {
    return produtos;
}

}
