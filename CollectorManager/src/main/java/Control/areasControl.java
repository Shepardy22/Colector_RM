/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Models.Area;
import Models.areaModel;

/**
 *
 * @author Yuri
 */
public class areasControl {

    private areaModel model;

    public areasControl() {
        this.model = new areaModel();
    }

    public void disconnect() {
        this.model.disconnect();
    }

    public boolean createTable(String nomeTabela) {
        return this.model.createTable(nomeTabela);
    }

    public boolean insertData(String nomeTabela, String barcode, int quantidade) {
        return this.model.insertData(nomeTabela, barcode, quantidade);
    }

    public boolean updateData(String nomeTabela, int id, String barcode, int quantidade) {
        return this.model.updateData(nomeTabela, id, barcode, quantidade);
    }

    public Area retrieveData(String nomeTabela) {
        return this.model.retrieveData(nomeTabela);
    }

    public boolean deleteTable(String nomeTabela) {
        return this.model.deleteTable(nomeTabela);

    }
}
