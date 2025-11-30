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
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class SecondaryController implements Initializable{
    
    
    int contElectrolisis = 0;

    @FXML
    private TextField ingTiempo;
    @FXML
    private AreaChart<?, ?> produccionH2;
    
    static ResultadosSimulados r1 = new ResultadosSimulados();
    
    @FXML
    private Slider sliderTemp;
    @FXML
    private Slider sliderEficiencia;
    @FXML
    private Slider sliderPresion;
    @FXML
    private Slider sliderCorriente;
    @FXML
    private Slider sliderVoltaje;
    @FXML
    private Label maxCorriente;
    @FXML
    private Label minCorriente;
    @FXML
    private Label maxVol;
    @FXML
    private Label minVol;
    @FXML
    private Label maxTemp;
    @FXML
    private Label minTemp;
    @FXML
    private TextField co2Evitado;
    @FXML
    private TextField molesH2;
    @FXML
    private TextField energiaConsumida;
    @FXML
    private TextField kgH2;
    @FXML
    private TextField eficienciaEnergetica;
    
   

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
        
        double corriente = sliderCorriente.getValue();
        double voltaje = sliderVoltaje.getValue();
        double tiempo = 0;
        
        try{
            
        tiempo = Double.parseDouble(ingTiempo.getText());
        
        if(tiempo<=0){
            
            JOptionPane.showMessageDialog(null, "No podemos retroceder en el tiempo :(.");
            return;
        }

        else if(tiempo>=10000){
            JOptionPane.showMessageDialog(null, "Lamentablemente no soporta tanto tiempo.");
            return;

        }
        
        }
        
        catch(NumberFormatException e){
            
            JOptionPane.showMessageDialog(null, "Ingresaste un texto no un numero.");
            return;
        }
        
        
        
        double eficiencia = sliderEficiencia.getValue()/100;
        double temperatura = sliderTemp.getValue();
        double presion = sliderPresion.getValue();
        
        System.out.println("Temperatura: "+ sliderTemp.getValue());
        
        ParametrosSimulados p1 = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura, presion);
        
        
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
        
        energiaConsumida.setText(String.valueOf(r1.getEnergiaConsumida())+" KW/h");
        
        String eficienciaFinal = String.format("%.2f", r1.getEficienciaEnergetica());
        
        eficienciaEnergetica.setText(eficienciaFinal+"%");
        
        String molesFinal = String.format("%.2f", r1.getMoles());
        
        molesH2.setText(molesFinal +" moles de H₂");
        
        String kgFinal = String.format("%.4f", (r1.getKgh2()));
        
        kgH2.setText(kgFinal+" KgH₂");
        
        String co2Final = String.format("%.4f", (r1.getCo2Evitado()));
        
        co2Evitado.setText(String.valueOf(co2Final+" KgCO₂"));
        
        
        
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

    @FXML
    private void electrolisisAlcalina(ActionEvent event) {
        
        maxVol.setText("  2.4 V");
        minVol.setText("  1.8 V");
        maxCorriente.setText("  600 A");
        minCorriente.setText("  200 A");
        maxTemp.setText("  353 °K");
        minTemp.setText("  333 °K");
        sliderTemp.setMin(333); sliderTemp.setMax(353);
        sliderCorriente.setMin(200); sliderCorriente.setMax(600); 
        sliderVoltaje.setMin(1.8); sliderVoltaje.setMax(2.4);
        sliderTemp.setValue(353);
        sliderVoltaje.setValue(2.4);
        sliderCorriente.setValue(600);
        
        contElectrolisis = 0;
        

    }

    @FXML
    private void electrolisisPEM(ActionEvent event) {
        maxVol.setText("  2.2 V");
        minVol.setText("  1.4 V");
        maxCorriente.setText("  3000 A");
        minCorriente.setText("  500 A");
        maxTemp.setText("  363 °K");
        minTemp.setText("  323 °K");
        sliderTemp.setMin(323); sliderTemp.setMax(363);
        sliderCorriente.setMin(500); sliderCorriente.setMax(3000); 
        sliderVoltaje.setMin(1.4); sliderVoltaje.setMax(2.2);
        sliderTemp.setValue(363);
        sliderVoltaje.setValue(2.2);
        sliderCorriente.setValue(3000);
        
        contElectrolisis = 1;
        
    }

    @FXML
    private void preBaja(ActionEvent event) {
        
        
        if(contElectrolisis == 0){
        
        double corriente = 200;
        double voltaje = 1.8;
        double tiempo = 3600;
        double eficiencia = 0.1;
        double temperatura = 333;
        double presion = 1;
        
        ParametrosSimulados p1 = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura, presion);
        
        
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
        
        else{
            
        double corriente = 500;
        double voltaje = 1.4;
        double tiempo = 3600;
        double eficiencia = 0.1;
        double temperatura = 323;
        double presion = 1;
        
        ParametrosSimulados p1 = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura, presion);
        
        
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
        
    }
    
    

    @FXML
    private void preMedia(ActionEvent event) {
        
        if(contElectrolisis == 0){
        
        double corriente = 400;
        double voltaje = 2.1;
        double tiempo = 3600;
        double eficiencia = 0.6;
        double temperatura = 343;
        double presion = 1;
        
        ParametrosSimulados p1 = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura, presion);
        
        
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
        
        else{
            
        double corriente = 1750;
        double voltaje = 1.25;
        double tiempo = 3600;
        double eficiencia = 0.6;
        double temperatura = 343;
        double presion = 1;
        
        ParametrosSimulados p1 = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura, presion);
        
        
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
        
        
    }

    @FXML
    private void preAlta(ActionEvent event) {
        
        
        if(contElectrolisis == 0){
        
        double corriente = 600;
        double voltaje = 2.4;
        double tiempo = 3600;
        double eficiencia = 1;
        double temperatura = 353;
        double presion = 1;
        
        ParametrosSimulados p1 = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura, presion);
        
        
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
        
        else{
            
        double corriente = 3000;
        double voltaje = 2.2;
        double tiempo = 3600;
        double eficiencia = 1;
        double temperatura = 363;
        double presion = 1;
        
        ParametrosSimulados p1 = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura, presion);
        
        
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
        
        
        
    }
}
