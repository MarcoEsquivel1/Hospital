/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author MARCO RENÉ ESQUIVEL JUÁREZ
 */
public class Areas {
    private String nombre;
    private Persona oGerente;
    private ArrayList<Persona> lMed;
    
    public Areas(String pNom, Persona oGer, ArrayList<Persona> pMed)
    {
        this.setNombre(pNom);
        this.setoGerente(oGer);
        this.setlMed(pMed);
    }  

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the oGerente
     */
    public Persona getoGerente() {
        return oGerente;
    }

    /**
     * @param oGerente the oGerente to set
     */
    public void setoGerente(Persona oGerente) {
        this.oGerente = oGerente;
    }

    /**
     * @return the lMed
     */
    public ArrayList<Persona> getlMed() {
        return lMed;
    }

    /**
     * @param lMed the lMed to set
     */
    public void setlMed(ArrayList<Persona> lMed) {
        this.lMed = lMed;
    }
}
