/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Area;
import java.util.Map;

/**
 *
 * @author Yuri
 */
public class AreaView {
    public void printArea(Area area) {
    System.out.println("Área: " + area.getNome() + "\nProdutos:");
    Map<String, Integer> produtos = area.getProdutos();
    
    for (String barcode : produtos.keySet()) {
        int quantidade = produtos.get(barcode);
        System.out.println("- Barcode: " + barcode + " Quantidade: " + quantidade);
    }
}
    
}
