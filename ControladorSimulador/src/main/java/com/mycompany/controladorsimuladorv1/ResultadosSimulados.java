/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controladorsimuladorv1;

/**
 *
 * @author waki
 */
import java.util.ArrayList;

/**
 *
 * @author waki
 */
public class ResultadosSimulados {
    
    
    
    
    
    private static ArrayList<ParametrosSimulados> resultados = new ArrayList<>();
    private double moles;
    private double Kgh2;
    private double volumen;
    private double energiaConsumida;
    private double co2Evitado;
    private double eficienciaEnergetica;
    

    public ResultadosSimulados() {
        
    }

    public static void setResultados(ArrayList<ParametrosSimulados> resultados) {
        ResultadosSimulados.resultados = resultados;
    }

    public void agregarResultado(ParametrosSimulados PS){
        
        resultados.add(PS);
    
    }
    
    public double simularResultados(int indice, double tiempo){
        
        
        moles = (resultados.get(indice).getCorriente() * tiempo * resultados.get(indice).getEficienciaFaradica()) / (2 * 96485);
        
        volumen = (moles * 0.082057 * resultados.get(indice).getTemperatura())/resultados.get(indice).getPresion();
        
        energiaConsumida = (resultados.get(indice).getCorriente()* resultados.get(indice).getVoltaje()*resultados.get(indice).getTiempoElectrolisis())/3600000;
        
        Kgh2 = (moles *  0.002016);
        
        co2Evitado = Kgh2 * 10;
        
        eficienciaEnergetica = ((moles * 241.8)/ (energiaConsumida*3600))*100;
    
        return volumen;
    }

    public double getEficienciaEnergetica() {
        return eficienciaEnergetica;
    }
    
    
    
    
    
    

    public ArrayList<ParametrosSimulados> getResultados() {
        return resultados;
    }

    public double getMoles() {
        return moles;
    }

    public void setMoles(double moles) {
        this.moles = moles;
    }

    public double getKgh2() {
        return Kgh2;
    }

    public void setKgh2(double Kgh2) {
        this.Kgh2 = Kgh2;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getEnergiaConsumida() {
        return energiaConsumida;
    }

    public void setEnergiaConsumida(double energiaConsumida) {
        this.energiaConsumida = energiaConsumida;
    }

    public double getCo2Evitado() {
        return co2Evitado;
    }

    public void setCo2Evitado(double co2Evitado) {
        this.co2Evitado = co2Evitado;
    }
    
    
    
    
}
