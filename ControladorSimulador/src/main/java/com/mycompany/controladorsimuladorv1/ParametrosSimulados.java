
package com.mycompany.controladorsimuladorv1;

public class ParametrosSimulados {
    
    private double corriente;
    private double voltaje;
    private double tiempoElectrolisis;
    private double eficienciaFaradica;
    private double temperatura;
    private double presion;
    private double factorCO2;

    public ParametrosSimulados(double corriente, double voltaje, double tiempoElectrolisis, double eficienciaFaradica, double temperatura, double presion) {
        this.corriente = corriente;
        this.voltaje = voltaje;
        this.tiempoElectrolisis = tiempoElectrolisis;
        this.eficienciaFaradica = eficienciaFaradica;
        this.temperatura = temperatura;
        this.presion = presion;
       
    }

    public double getPresion() {
        return presion;
    }

    public void setPresion(double presion) {
        this.presion = presion;
    }
    
    public boolean validarParametros(){
    
    return true;
    }
    
    public void actualizarParametros(){
    
    
    }

    public double getCorriente() {
        return corriente;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public double getTiempoElectrolisis() {
        return tiempoElectrolisis;
    }

    public double getEficienciaFaradica() {
        return eficienciaFaradica;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getFactorCO2() {
        return factorCO2;
    }
    
    public void obtenerParametros(){
     
        
    }
    
}
