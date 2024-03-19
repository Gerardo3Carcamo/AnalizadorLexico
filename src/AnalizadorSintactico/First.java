/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorSintactico;

import java.util.List;

/**
 *
 * @author 000093883
 */
public class First {
    
    private String Simbolo;
    private List<String> Terminales;

    public First(String Simbolo, List<String> Terminales) {
        this.Simbolo = Simbolo;
        this.Terminales = Terminales;
    }

    public String getSimbolo() {
        return Simbolo;
    }

    public void setSimbolo(String Simbolo) {
        this.Simbolo = Simbolo;
    }

    public List<String> getTerminales() {
        return Terminales;
    }

    public void setTerminales(List<String> Terminales) {
        this.Terminales = Terminales;
    }
    
}
