/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controladorsimuladorv1;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import com.mycompany.controladorsimuladorv1.SecondaryController;

/**
 * FXML Controller class
 *
 * @author waki
 */

public class PrimaryController  {

    
    
    
    @FXML
    private void irInicio(ActionEvent event) throws IOException {
        
        
    }


    @FXML
    private void irTablas(ActionEvent event) {
        
        
    }

    @FXML
    private void irGraficadora(ActionEvent event) throws IOException {
        
        App.setRoot("secondary");
    }



}
