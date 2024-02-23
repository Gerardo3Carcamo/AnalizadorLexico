/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author 000093883
 */
public class Lexico {

    private HashMap<String, Integer> mapColumns = new HashMap<>();
    private int line = 1;
    private int apuntador = 0;
    private int estado = 0;
    private int columna = 0;
    private ArrayList<String> texto = new ArrayList<>();
    private ArrayList<Lexema> lexemas = new ArrayList<>();
    private String[][] matrizEstados = {
        {"20", "1016", "1018", "1019", "1020", "1021", "1022", "1023", "1024", "1025", "18", "22", "1017", "5", "24", "26", "500", "1015", "1", "500", "500", "2", "1", "28", "0"},
        {"1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1", "1", "1", "1", "1", "1", "500", "1000"},
        {"1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "3", "1001", "1001", "1001", "1001", "2", "10", "500", "1001"},
        {"500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "4", "500", "500", "500"},
        {"1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "4", "10", "500", "1002"},
        {"1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "6", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003"},
        {"7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7"},
        {"7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "8", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7"},
        {"7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "9", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7"},
        {"1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004"},
        {"500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "11", "12", "500", "500", "500", "500", "500", "500", "500", "500", "500", "13", "500", "500", "500"},
        {"500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "13", "500", "500", "500"},
        {"500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "13", "500", "500", "500"},
        {"1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "13", "1026", "1026", "1026"},
        {"500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "15", "16", "500", "500", "500", "500", "500", "500", "500", "500", "500", "17", "500", "500", "500"},
        {"500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "15", "16", "500", "500", "500", "500", "500", "500", "500", "500", "500", "17", "500", "500", "500"},
        {"500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "15", "16", "500", "500", "500", "500", "500", "500", "500", "500", "500", "17", "500", "500", "500"},
        {"1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "17", "1027", "1027", "1027"},
        {"1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "19", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005"},
        {"1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006"},
        {"1007", "21", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007"},
        {"1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008"},
        {"1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "23", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009"},
        {"1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010"},
        {"1011", "25", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011"},
        {"1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012"},
        {"1013", "27", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013"},
        {"1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014"},
        {"28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "28", "1028", "28"},
        {"1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028"}
    };

    private final String[] palabrasClave = {
        "include",
        "int",
        "float",
        "double",
        "string",
        "char",
        "function",
        "return",
        "call",
        "if",
        "elif",
        "else",
        "while",
        "for",
        "do",
        "and",
        "or",
        "abs",
        "sqr",
        "sqrt",
        "sin",
        "sinh",
        "cosh",
        "cos",
        "tang",
        "tanh",
        "atang",
        "asin",
        "acos",
        "log",
        "exponential",
        "chr",
        "float",
        "length",
        "printf",
        "scanf",
        "pow",
        "cbrt",
        "fact",
        "round",
        "trunc",
        "minimal",
        "maximal",
        "floor"
    };

    private void initMapColumns() {
        mapColumns.put(":", 0);
        mapColumns.put("=", 1);
        mapColumns.put(";", 2);
        mapColumns.put(",", 3);
        mapColumns.put("[", 4);
        mapColumns.put("]", 5);
        mapColumns.put("(", 6);
        mapColumns.put(")", 7);
        mapColumns.put("{", 8);
        mapColumns.put("}", 9);
        mapColumns.put("+", 10);
        mapColumns.put("-", 11);
        mapColumns.put("*", 12);
        mapColumns.put("/", 13);
        mapColumns.put(">", 14);
        mapColumns.put("<", 15);
        mapColumns.put(".", 16);
        mapColumns.put("#", 17);
        mapColumns.put("^[a-zA-Z][$#a-zA-Z0-9]*$", 18);
        mapColumns.put("$", 19);
        mapColumns.put("_", 20);
        mapColumns.put("[0-9]", 21);
        mapColumns.put("E", 22);
        mapColumns.put("\"", 23);
        mapColumns.put(" ", 24);
    }

    private String listToString(ArrayList<String> data) {
        StringBuilder builder = new StringBuilder();
        data.forEach(x -> { 
            builder.append(x); 
        });
        return builder.toString();
    }

    private Lexema processFinalStates(int estado, String lexema, int line) {
        Lexema response = new Lexema("Error lexico", "Error", 500, line);
        switch (estado) {
            case 1000 ->
                response = Arrays.asList(palabrasClave).contains(listToString(texto).trim()) ? new Lexema("Palabra reservada", lexema, estado, line) : new Lexema("Identificador", lexema, estado, line);
            case 1001 ->
                response = new Lexema("Numero entero", lexema, estado, line);
            case 1026 ->
                response = new Lexema("Numero entero con notación cientifica", lexema, estado, line);
            case 1002 ->
                response = new Lexema("Numero decimal", lexema, estado, line);
            case 1027 ->
                response = new Lexema("Numero decimal con notación cientifica", lexema, estado, line);
            case 1028 ->
                response = new Lexema("Cadena string", lexema, estado, line);
            case 1003, 1005, 1009, 1017, 1006, 1010 ->
                response = new Lexema("Operador matematico", lexema, estado, line);
            case 1008 ->
                response = new Lexema("Operador de asignación", lexema, estado, line);
            case 1011, 1012, 1013, 1014 ->
                response = new Lexema("Operador booleano", lexema, estado, line);
            case 1007, 1015, 1016, 1018, 1019, 1020, 1021, 1022, 1023, 1024, 1025 ->
                response = new Lexema("Simbolo", lexema, estado, line);
            case 1004 -> response = new Lexema("Comentario", lexema, estado, line);
        }
        return response;
    }

    public ArrayList<Lexema> analizar(String codigo) {
        initMapColumns();
        codigo = codigo.concat(" ").replaceAll("\t", "");
        while (apuntador != (codigo.length())) {
            char actual = codigo.charAt(apuntador);
            if((int)actual == 10){
                line++;
                actual = ' ';
            }
            apuntador++;
            texto.add(String.valueOf(actual));
            columna = Character.isLetter(actual) ? 18 : (Character.isDigit(actual) ? 21 : mapColumns.get(String.valueOf(actual)));
            try{
                if((estado == 2 || estado == 4) && actual == 'E'){
                    estado = 10;
                }else{
                estado = Integer.parseInt(matrizEstados[estado][columna]);   
                }
            }catch(ArrayIndexOutOfBoundsException ex){
                lexemas.add(new Lexema("Error de sintaxis", "", 500, line));
                estado = 0;
                texto.clear();
                columna = 0;
                apuntador--;
            }
            if (estado >= 1000) {
                if (!listToString(texto).contains("E") && (estado == 1027 || estado == 1028) && listToString(texto).contains("+")) {
                    estado = 1005;
                }else if(!listToString(texto).contains("E") && (estado == 1027 || estado == 1028) && listToString(texto).contains("-")){
                    estado = 1009;
                }
                if(!listToString(texto).endsWith(" ") && estado < 1015){
                    apuntador--;
                    texto.remove(texto.size()-1);
                }
                lexemas.add(processFinalStates(estado, listToString(texto).replace(" ", ""), line));
                estado = 0;
                texto.clear();
                columna = 0;
            }
            
        }   
        return lexemas;
    }

}
