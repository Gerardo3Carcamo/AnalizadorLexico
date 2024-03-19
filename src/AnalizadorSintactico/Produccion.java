/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorSintactico;

import java.util.LinkedHashSet;
import java.util.List;

/**
 *
 * @author 000093883
 */
public class Produccion {
    
    private List<ListedProduction> produccion;
    
    public Produccion(List<ListedProduction> produccion){
        this.produccion = produccion; 
    }

    public List<ListedProduction> getProduccion() {
        return produccion;
    } 
    
    
}
