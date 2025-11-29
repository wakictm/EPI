package com.mycompany.controladorsimuladorv1;

import com.mycompany.controladorsimuladorv1.SecondaryController;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class TertiaryController implements Initializable {

    @FXML
    private ScrollPane chartContainer; 

   
    private ResultadosSimulados r2 = SecondaryController.r1; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

       
        VBox chartsVBox = new VBox(10); // 10px spacing between charts

        
        if (r2.getResultados().isEmpty()) {
            
            System.out.println("No previous results to display.");
            chartContainer.setContent(chartsVBox); 
            return;
        }

      
        for (int i = 0; i < r2.getResultados().size(); i++) {
            
            NumberAxis xAxis = new NumberAxis();
            NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Tiempo de Electrólisis");
            yAxis.setLabel("Volumen de H2");

         
            AreaChart<Number, Number> areaChart = new AreaChart<>(xAxis, yAxis);
            areaChart.setTitle("Record: Volumen de H2 - Resultado " + (i + 1));

          
            XYChart.Series<Number, Number> datos = new XYChart.Series<>();
            datos.setName("Volumen de H2 - Resultado " + (i + 1));

           
            for (int i2 = 0; i2 <= r2.getResultados().get(i).getTiempoElectrolisis(); i2++) {
                datos.getData().add(new XYChart.Data<>(i2, r2.simularResultados(i, i2)));
            }

           
            areaChart.getData().add(datos);

           
            chartsVBox.getChildren().add(areaChart);
        }

       
        chartContainer.setContent(chartsVBox);
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
}
