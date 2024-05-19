/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import AnalizadorSintactico.*;
import analizadorlexico.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author 000093883
 */
public class Main {
    
    private String readTextFromFile(String filePath) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

//    /**
//     * @param args the command line arguments
//     * @throws AnalizadorSintactico.SintaxisException
//     */
//    public static void main(String[] args) throws SintaxisException {
//        int move = 0;
//        Stack<Integer> entrada = new Stack<>();
//        Stack<String> stack = new Stack<>();
//        stack.push("P");
//        Gramatica gramatica = new Gramatica();
//        gramatica.initGramatica();
//        Lexico lexico = new Lexico();
//        Analizador sintactico = new Analizador();
//        gramatica.initGramatica();
//        sintactico.initMaps();
//        List<Lexema> list = lexico.analizar("""
//                                            
//                                            """);
//        list = lexico.deleteAllComments(list);
//        for (int i = list.size() - 1; i >= 0; i--) {
//            entrada.push(list.get(i).getState());
//        }
//        int i = 0;
//        while (!stack.isEmpty() && !entrada.isEmpty()) {
//            if (move == 0) {
//                stack = sintactico.GetSymbols(stack, entrada);
//            } else {
//                try {
//                    if(stack.peek().equals("null")){
//                        stack.pop();
//                    }
//                    var flag = stack.peek().equals(sintactico.terminalTokens.get(entrada.peek()));
//                    if (flag) {
//                        System.out.println("se acepta el simbolo: " +  stack.peek());
//                        stack.pop();
//                        entrada.pop();
//                        i++;
//                    } else {
//                        stack = sintactico.GetSymbols(stack, entrada);
//                    }
//                } catch (Exception ex) {
//                    System.out.println("Se requiere: " + stack.peek());
//                    list.forEach(lexema ->{
//                        if(lexema.getState() == entrada.peek()) System.out.println("Y se proporciono: " + lexema.getValue());
//                    });
//                    break;
//                }
//
//            }
//            move++;
//        }
//        if(!stack.isEmpty() || !entrada.isEmpty()){
//            throw new SintaxisException("No se proporciono el código fuente completo para poder ser compilado");
//        }else{
//            System.out.println("Final del programa, ejecucion correcta.");
//        }
//    }

}
