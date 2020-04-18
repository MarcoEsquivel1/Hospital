/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


/**
 *
 * @author MARCO RENÉ ESQUIVEL JUÁREZ
 */
public class Consulta {
    private String numConsulta;
    private int dias;
    private double monto;
    
    
    public Consulta(String pNC, int pDias, double pMon)
    {   
        this.setNumCons(pNC);
        this.setDias(pDias);
        this.setMonto(pMon);
       
    }

    /**
     * @return the numTransac
     */
    public String getNumCons() {
        return numConsulta;
    }

    /**
     * @param numTransac the numTransac to set
     */
    public void setNumCons(String numTransac) {
        this.numConsulta = numTransac;
    }

    /**
     * @return the fechaHora
     */
    
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        this.dias = dias;
    }
}
