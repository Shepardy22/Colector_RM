/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Models.UserModel;

/**
 *
 * @author Yuri
 */
public class UserControl {
    
    private final UserModel userModel;

public UserControl() {
    this.userModel = new UserModel();
}

public void conectar() {
     this.userModel.connect();
}

public void desconectar() {
     this.userModel.disconnect();
}

public void criarTabela() {
    
    this.userModel.createTable();
    
}

public void inserirDados(int id, String nome, int senha) {
     
     this.userModel.insertData(id, nome, senha);
   
}

public void atualizarDados(int id, String nome, int senha) {
     this.userModel.updateData(id, nome, senha);
}

public void recuperarDados() {
   
    this.userModel.retrieveData();
   
}
}
