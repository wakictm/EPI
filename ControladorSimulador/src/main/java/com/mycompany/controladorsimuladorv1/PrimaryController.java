/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controladorsimuladorv1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author waki
 */
public class PrimaryController implements Initializable {

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


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void irInicio(ActionEvent event) throws IOException {
        
        App.setRoot("primary");
    }

    @FXML
    private void irGraficadora(ActionEvent event) throws IOException {
        
        App.setRoot("secondary");
        
        
    }

    @FXML
    private void irTablas(ActionEvent event) {
    }

    @FXML
    private void graficar(ActionEvent event) {
        
        double corriente = Double.parseDouble(ingCorriente.getText());
        double voltaje = Double.parseDouble(ingVoltaje.getText());
        double tiempo = Double.parseDouble(ingTiempo.getText());
        double eficiencia = (Double.parseDouble(ingEficiencia.getText()))/100;
        double temperatura = Double.parseDouble(ingTemperatura.getText());
        
        XYChart.Series datos = new XYChart.Series();
        datos.setName("Volumen de H2");
        
        ParametrosSimulados p1 = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura);
        ResultadosSimulados r1 = new ResultadosSimulados();
        
        for(int i = 1; i<tiempo;i++){
        
            datos.getData().add(new XYChart.Data(String.valueOf(i),r1.entregarResultado(p1, i)));
        
        }
        
        produccionH2.getData().addAll(datos);
        
    }


}
