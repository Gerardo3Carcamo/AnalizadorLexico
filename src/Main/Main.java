/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import AnalizadorSintactico.*;
import analizadorlexico.*;
import java.util.ArrayList;
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
        ArrayList<Lexema> list = lexico.analizar("""
                                            //Seccion Include//
                                            #include <prueba>
                                            //Seccion Constantes//
                                            x := 1, variables :
                                            //Seccion Variables//
                                            hola, adios, gerardo : int[20][2][0]
                                            //Seccion Function//
                                            double[10][20] function pruebaFuncion(){
                                                //Seccion Bloque//
                                                printf("Hola");
                                                scanf();
                                                variableFuncion = 1;
                                                abs(identificador);
                                                for[i = 1; i < 0; i++]{
                                                    hola = 10E12;
                                                    adios = 0;
                                                    abs(hola);
                                                    call funcionprueba();
                                                };
                                            } //Seccion Return// return identificador
                                            
                                            int function funcionprueba(){
                                                minimal([1,2,3,4,6]);
                                            } return hola
                                            //
                                                 Esto es un comentario multilinea
                                                 se demuestra que en la parte lexica,
                                                 si detecta los comentarios correctamente
                                                 y en la parte sintactica los ignora ya que 
                                                 no tienen ningun efecto funcional en el codigo
                                            //
                                            {
                                                minimal([1,2,3,4,6]);
                                                call identificador(prueba: int);
                                            }
                                            """);
        list = lexico.deleteAllComments(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            entrada.push(list.get(i).getState());
        }
        int i = 0;
        while (!stack.isEmpty() && !entrada.isEmpty()) {
            if(entrada.peek() == 1026){
                int io = 0;
            }
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
                        i++;
                    } else {
                        stack = sintactico.GetSymbols(stack, entrada);
                    }
                } catch (Exception ex) {
                    System.out.println("Se requiere: " + stack.peek());
                    list.forEach(lexema ->{
                        if(lexema.getState() == entrada.peek()) System.out.println("Y se proporciono: " + lexema.getValue());
                    });
                    break;
                }

            }
            move++;
        }
        if(!stack.isEmpty() || !entrada.isEmpty()){
            throw new SintaxisException("No se proporciono el código fuente completo para poder ser compilado");
        }else{
            System.out.println("Final del programa, ejecucion correcta.");
        }
    }

}
