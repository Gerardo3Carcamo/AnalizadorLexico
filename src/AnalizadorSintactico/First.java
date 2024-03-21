/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorSintactico;

/**
 *
 * @author 000093883
 */
public class First {
    
    private String Produccion;
    private int Line;

    public First(String Produccion, int Line) {
        this.Produccion = Produccion;
        this.Line = Line;
    }

    public String getProduccion() {
        return Produccion;
    }

    public void setProduccion(String Produccion) {
        this.Produccion = Produccion;
    }

    public int getLine() {
        return Line;
    }

    public void setLine(int Line) {
        this.Line = Line;
    }

    @Override
    public String toString() {
        return "{" + "Simbolo Terminal => " + Produccion + ", Line = " + Line + '}';
    }
    
    
    
}
