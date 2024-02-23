/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico;

/**
 *
 * @author 000093883
 */
public class Lexema {
    
    private final String token, value;
    private final int state, line;
    
    public int getLine(){
        return line;
    }
    
    public int getState(){
        return state;
    }

    public String getToken() {
        return token;
    }

    public String getValue() {
        return value;
    }

    public Lexema(String token, String value, int state, int line) {
        this.token = token;
        this.value = value;
        this.state = state;
        this.line = line;
    }
    
    @Override
    public String toString(){
        return "Token: " + token + " Lexema -> " + value + " Linea: " + line + " Estado final: " + state + "\n";
    }
}
