/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controladorsimulador;

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
