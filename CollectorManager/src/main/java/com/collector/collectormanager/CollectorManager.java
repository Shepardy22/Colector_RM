/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.collector.collectormanager;

import dbConnect.SQLiteConnection;

/**
 *
 * @author Yuri
 */
public class CollectorManager {

    public static void main(String[] args) {
        
        SQLiteConnection db = new SQLiteConnection();
        
        db.connect();
        db.createTable();
        db.insertData();
        db.disconnect();
    }
}
