
package etc1.etc1;


public class ParametrosSimulados {
    private double corriente;
    private double voltaje;
    private double tiempoElectrolisis;
    private double eficienciaFaradica;
    private double temperatura;
    private double factorCO2;
    
    public ParametrosSimulados(double corriente, double voltaje, double tiempoElectrolisis, double eficienciaFaradica, double temperatura, double factorCO2) {
        this.corriente = corriente;
        this.voltaje = voltaje;
        this.tiempoElectrolisis = tiempoElectrolisis;
        this.eficienciaFaradica = eficienciaFaradica;
        this.temperatura = temperatura;
        this.factorCO2 = factorCO2;
 
 }  
    
    public boolean validarParametros(){
    
    return true;
    }
    
    public void actualizarParametros(){
    
    
    }
    
    public void obtenerParametros(){
     
        
    }
        
}
