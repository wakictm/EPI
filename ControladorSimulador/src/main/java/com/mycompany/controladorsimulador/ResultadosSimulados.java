/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etc1.etc1;

/**
 *
 * @author josue
 */
public class ResultadosSimulados {
    private ArrayList<Double> resultados = new ArrayList<>();
    private double moles;
    private double Kgh2;
    private double volumen;
    private double energiaConsumida;
    private double co2Evitado;
    
    public ResultadosSimulados(double moles, double Kgh2, double volumen, double energiaConsumida, double co2Evitado) {
        this.moles = moles;
        this.Kgh2 = Kgh2;
        this.volumen = volumen;
        this.energiaConsumida = energiaConsumida;
        this.co2Evitado = co2Evitado;
}
    
        public void entregarResultado(double corriente, double tiempo, double eficiencia, double temperatura){
    
        double resultado = 0;
        
        resultado = (corriente * tiempo * eficiencia * temperatura * 0.082057)/(2);
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