/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorSintactico;

/**
 *
 * @author 000093883
 */
public class SintaxisException extends Throwable{
    
    public SintaxisException(){
        super("Error de sintaxis");
    }
    
    public SintaxisException(String message){
        super(message);
    }
    
}
