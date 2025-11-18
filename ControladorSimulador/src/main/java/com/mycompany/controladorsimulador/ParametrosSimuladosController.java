/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etc1.etc1;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ParametrosSimuladosController {
    
    @FXML
    private TextField corrienteField;
    @FXML
    private TextField voltajeField;
    @FXML
    private TextField tiempoElectrolisisField;
    @FXML
    private TextField eficienciaFaradicaField;
    @FXML
    private TextField temperaturaField;
    @FXML
    private TextField factorCO2Field;
    @FXML
    private AreaChart graficoarea;
    
    private ParametrosSimulados params = new ParametrosSimulados(0, 0, 0, 0, 0, 0);
    
    @FXML
    private void validarParametros() {

        boolean valid = params.validarParametros();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validación");
        alert.setHeaderText(null);
        alert.setContentText(valid ? "Parámetros válidos" : "Parámetros inválidos");
        alert.showAndWait();
    }
    
    @FXML
    private void actualizarParametros() {
        try {

            double corriente = Double.parseDouble(corrienteField.getText());
            double voltaje = Double.parseDouble(voltajeField.getText());
            double tiempo = Double.parseDouble(tiempoElectrolisisField.getText());
            double eficiencia = Double.parseDouble(eficienciaFaradicaField.getText());
            double temperatura = Double.parseDouble(temperaturaField.getText());
            double factorCO2 = Double.parseDouble(factorCO2Field.getText());
            
            params = new ParametrosSimulados(corriente, voltaje, tiempo, eficiencia, temperatura, factorCO2);
            params.actualizarParametros();  
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Actualización");
            alert.setHeaderText(null);
            alert.setContentText("Parámetros actualizados");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ingrese valores numéricos válidos");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void obtenerParametros() {

        params.obtenerParametros();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Obtener Parámetros");
        alert.setHeaderText(null);
        alert.setContentText("Corriente: " + params.getCorriente() + "\n" +
                             "Voltaje: " + params.getVoltaje() + "\n" +
                             "Tiempo: " + params.getTiempoElectrolisis());
        alert.showAndWait();
    }
}

    
}
