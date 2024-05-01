/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import AnalizadorSintactico.*;
import analizadorlexico.*;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author 000093883
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws AnalizadorSintactico.SintaxisException
     */
    public static void main(String[] args) throws SintaxisException {
        int move = 0;
        Stack<Integer> entrada = new Stack<>();
        Stack<String> stack = new Stack<>();
        stack.push("P");
        Gramatica gramatica = new Gramatica();
        gramatica.initGramatica();
        Lexico lexico = new Lexico();
        Analizador sintactico = new Analizador();
        gramatica.initGramatica();
        sintactico.initMaps();
        List<Lexema> list = lexico.analizar("""
                                            #include <prueba> 
                                            X := FUENTE := y := p
                                            """);
        for (int i = list.size() - 1; i >= 0; i--) {
            entrada.push(list.get(i).getState());
        }
        while (!stack.isEmpty() && !entrada.isEmpty()) {
            if (move == 0) {
                stack = sintactico.GetSymbols(stack, entrada);
            } else {
                try {
                    if(stack.peek().equals("null")){
                        stack.pop();
                    }
                    var flag = stack.peek().equals(sintactico.terminalTokens.get(entrada.peek()));
                    if (flag) {
                        System.out.println("se acepta el simbolo: " +  stack.peek());
                        stack.pop();
                        entrada.pop();
                    } else {
                        stack = sintactico.GetSymbols(stack, entrada);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    break;
                }

            }
            move++;
        }
        if(!stack.isEmpty() || !entrada.isEmpty()){
            throw new SintaxisException();
        }
    }

}
