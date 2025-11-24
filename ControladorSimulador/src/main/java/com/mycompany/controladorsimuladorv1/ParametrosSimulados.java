/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controladorsimuladorv1;

/**
 *
 * @author waki
 */
public class ParametrosSimulados {
    
    private double corriente;
    private double voltaje;
    private double tiempoElectrolisis;
    private double eficienciaFaradica;
    private double temperatura;
    private double factorCO2;

    public ParametrosSimulados(double corriente, double voltaje, double tiempoElectrolisis, double eficienciaFaradica, double temperatura) {
        this.corriente = corriente;
        this.voltaje = voltaje;
        this.tiempoElectrolisis = tiempoElectrolisis;
        this.eficienciaFaradica = eficienciaFaradica;
        this.temperatura = temperatura;
       
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
