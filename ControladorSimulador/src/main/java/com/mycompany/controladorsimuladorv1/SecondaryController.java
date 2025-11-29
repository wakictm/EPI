package com.mycompany.controladorsimuladorv1;

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
    private void irTablas(ActionEvent event) throws IOException {
       App.setRoot("tertiary");
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
        maxCorriente.setText("  0.4 A");
        minCorriente.setText("  0.2 A");
        maxTemp.setText("  353 °K");
        minTemp.setText("  333 °K");
        sliderTemp.setMin(333); sliderTemp.setMax(353);
        sliderCorriente.setMin(0.2); sliderCorriente.setMax(0.4); 
        sliderVoltaje.setMin(1.8); sliderVoltaje.setMax(2.4);
        sliderTemp.setValue(353);
        sliderVoltaje.setValue(2.4);
        sliderCorriente.setValue(0.4);

    }

    @FXML
    private void electrolisisPEM(ActionEvent event) {
        maxVol.setText("  2.2 V");
        minVol.setText("  1.4 V");
        maxCorriente.setText("  2.0 A");
        minCorriente.setText("  0.5 A");
        maxTemp.setText("  363 °K");
        minTemp.setText("  323 °K");
        sliderTemp.setMin(323); sliderTemp.setMax(363);
        sliderCorriente.setMin(0.5); sliderCorriente.setMax(2); 
        sliderVoltaje.setMin(1.4); sliderVoltaje.setMax(2.2);
        sliderTemp.setValue(363);
        sliderVoltaje.setValue(2.2);
        sliderCorriente.setValue(2);

    }
}
    
    

