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
public class Relaciones {
    private Persona oPaciente;
    private Areas oArea;
    private Consulta oCons;
    private Persona oMed;

    
    public Relaciones(Persona pClien, Areas pArea, Persona pOMed, Consulta oCons)
    {
        this.setoClien(pClien);
        this.setoArea(pArea);
        this.setoCons(oCons);
        this.setoMed(pOMed);
    }

    /**
     * @return the oClien
     */
    public Persona getoClien() {
        return oPaciente;
    }

    /**
     * @param oClien the oClien to set
     */
    public void setoClien(Persona oClien) {
        this.oPaciente = oClien;
    }

    /**
     * @return the oArea
     */
    public Areas getoArea() {
        return oArea;
    }

    /**
     * @param oArea the oArea to set
     */
    public void setoArea(Areas oArea) {
        this.oArea = oArea;
    }

    /**
     * @return the oCons
     */
    public Consulta getoCons() {
        return oCons;
    }

    /**
     * @param oCons the oCons to set
     */
    public void setoCons(Consulta oCons) {
        this.oCons = oCons;
    }

    /**
     * @return the oMed
     */
    public Persona getoMed() {
        return oMed;
    }

    /**
     * @param oMed the oMed to set
     */
    public void setoMed(Persona oMed) {
        this.oMed = oMed;
    }
    
    
}
