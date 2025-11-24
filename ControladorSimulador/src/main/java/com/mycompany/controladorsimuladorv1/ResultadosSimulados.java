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

    public ResultadosSimulados() {
        
    }

    public static void setResultados(ArrayList<ParametrosSimulados> resultados) {
        ResultadosSimulados.resultados = resultados;
    }

    public void agregarResultado(ParametrosSimulados PS){
        
        resultados.add(PS);
    
    }
    
    public double simularResultados(int indice, double tiempo){
        
        double resultadoMoles = 0;
        
        resultadoMoles = (resultados.get(indice).getCorriente() * tiempo * resultados.get(indice).getEficienciaFaradica()) / (2 * 96485);
        
        volumen = resultadoMoles * 0.082057 * resultados.get(indice).getTemperatura();
    
        return volumen;
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
