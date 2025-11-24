package com.mycompany.controladorsimuladorv1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author waki
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

public class SecondaryController implements Initializable{
    
    
    
    @FXML
    private TextField ingCorriente;
    @FXML
    private TextField ingVoltaje;
    @FXML
    private TextField ingTiempo;
    @FXML
    private TextField ingEficiencia;
    @FXML
    private TextField ingTemperatura;
    @FXML
    private AreaChart<?, ?> produccionH2;
    
    ResultadosSimulados r1 = new ResultadosSimulados();
    
    
   
    @FXML
    private void irTablas(ActionEvent event) {
    }

    @FXML
    private void irGraficadora(ActionEvent event) {
    }
    
    
    @FXML
    private void irInicio(ActionEvent event) throws IOException {
        
        App.setRoot("primary");
    }
    
        @FXML
    private void graficar(ActionEvent event) {
        
        double corriente = Double.parseDouble(ingCorriente.getText());
        double voltaje = Double.parseDouble(ingVoltaje.getText());
        double tiempo = Double.parseDouble(ingTiempo.getText());
        double eficiencia = (Double.parseDouble(ingEficiencia.getText()))/100;
        double temperatura = Double.parseDouble(ingTemperatura.getText());
        
        
        ParametrosSimulados p1 = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura);
        
        
        r1.agregarResultado(p1);
        
        
        XYChart.Series datos = new XYChart.Series();
       
        
        for(int i = 0; i<r1.getResultados().size();i++){
            datos.setName("Volumen de H2 - Resultado " + (i + 1)); 
            datos.getData().clear();
            
            for (int i2 = 0; i2<=r1.getResultados().get(i).getTiempoElectrolisis(); i2++){
            
                datos.getData().add(new XYChart.Data(i2,r1.simularResultados(i, i2)));
            }
  
        }
        
        produccionH2.getData().addAll(datos);
        
        
    }

@Override
public void initialize(URL url, ResourceBundle rb) {
    System.out.println(r1.getResultados().size());
    produccionH2.getData().clear(); 
    
    if (r1.getResultados().isEmpty()) {
     
    } else {
        
        for (int i = 0; i < r1.getResultados().size(); i++) {
            XYChart.Series datos = new XYChart.Series();
            datos.setName("Volumen de H2 - Resultado " + (i + 1)); 
            
       
            for (int i2 = 0; i2 <= r1.getResultados().get(i).getTiempoElectrolisis(); i2++) {
                datos.getData().add(new XYChart.Data(i2, r1.simularResultados(i, i2)));
            }
            
       
            produccionH2.getData().add(datos);
        }
    }
}

    @FXML
    private void limpiar(ActionEvent event) {
        
        produccionH2.getData().clear();
        r1.getResultados().clear();
        
    }
}
