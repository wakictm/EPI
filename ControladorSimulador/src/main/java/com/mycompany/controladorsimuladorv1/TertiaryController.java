package com.mycompany.controladorsimuladorv1;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TertiaryController implements Initializable {

    @FXML
    private ScrollPane chartContainer;

    @FXML
    private VBox contenedorPrincipal;

    private ResultadosSimulados r2 = SecondaryController.r1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (r2.getResultados().isEmpty()) {
            System.out.println("No hay datos para graficar");
            return;
        }


        for (int i = 0; i < r2.getResultados().size(); i++) {

  
            NumberAxis xAxis = new NumberAxis();
            NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Tiempo de Electrólisis");
            yAxis.setLabel("Volumen de H2");

            AreaChart<Number, Number> areaChart = new AreaChart<>(xAxis, yAxis);
            areaChart.setTitle("Volumen de H2 - "+ r2.getResultados().get(i).getNombre() +" "+ (i + 1));

            XYChart.Series<Number, Number> datos = new XYChart.Series<>();
            datos.setName("Volumen de H2 - Resultado " + (i + 1));

            for (int t = 0; t <= r2.getResultados().get(i).getTiempoElectrolisis(); t++) {
                datos.getData().add(new XYChart.Data<>(t, r2.simularResultados(i, t)));
            }

            areaChart.getData().add(datos);

          
            VBox panelResultados = new VBox(8);
            panelResultados.setStyle("-fx-padding: 5; -fx-background-color:#f4f4f4;"
                    +  "-fx-background-radius: 8; -fx-border-color: #cccccc;");
            panelResultados.setPrefWidth(300);
            panelResultados.setMaxHeight(100);

         
            TextField txtMoles = new TextField();
            txtMoles.setEditable(false);

            TextField txtKgH2 = new TextField();
            txtKgH2.setEditable(false);

            TextField txtCO2 = new TextField();
            txtCO2.setEditable(false);

            TextField txtEficiencia = new TextField();
            txtEficiencia.setEditable(false);

            TextField txtEnergia = new TextField();
            txtEnergia.setEditable(false);

            
            double moles = r2.getMoles();
            double kgH2 = r2.getKgh2();
            double co2 = r2.getCo2Evitado();
            double eficiencia = r2.getEficienciaEnergetica();
            double energia = r2.getEnergiaConsumida();

            String molesFinal = String.format("%.2f", r2.getMoles());
            txtMoles.setText(molesFinal+" moles de H₂");
            
            String kgH2Final = String.format("%.4f", r2.getKgh2());
            txtKgH2.setText(kgH2Final+" Kg H₂");
            
            String co2Final = String.format("%.2f", r2.getCo2Evitado());
            txtCO2.setText(co2Final+ " Kg CO₂");
            
            txtEficiencia.setText(String.format("%.2f %%", eficiencia));
            txtEnergia.setText(String.format("%.2f kWh", energia));

            panelResultados.getChildren().addAll(
                new HBox(new Label("Moles:"), txtMoles),
                new HBox(new Label("Kg H₂:"), txtKgH2),
                new HBox(new Label("CO₂ evitado:"), txtCO2),
                new HBox(new Label("Eficiencia:"), txtEficiencia),
                new HBox(new Label("Energía consumida:"), txtEnergia)
            );

           
            HBox fila = new HBox(20);
            fila.getChildren().addAll(areaChart, panelResultados);

           
            contenedorPrincipal.getChildren().add(fila);
        }
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
    private void irTablas(ActionEvent event) { }
}

