/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.collector.collectormanager;


import Control.UserControl;
import Control.areasControl;
import Models.Area;
import Models.UserModel;
import View.AreaView;
import java.util.Map;

/**
 *
 * @author Yuri
 */
public class CollectorManager {

    public static void main(String[] args) {
        
        AreaView areaView = new AreaView();
        areasControl areaControl = new areasControl();

        



        //areaControl.createTable("mercearia");
        areaControl.insertData("mercearia", "789521112355", 48);
        
        Area area = areaControl.retrieveData("mercearia");
        areaView.printArea(area);

    }

    
    
}
