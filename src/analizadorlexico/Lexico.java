/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author 000093883
 */
public class Lexico {

    /**
     * 501 -> error al crear un numero decimal 502 -> error al crear un numero
     * con notacion cientifica
     *
     */
    private HashMap<String, Integer> mapColumns = new HashMap<>();
    private int line = 1;
    private int apuntador = 0;
    private int estado = 0;
    private int columna = 0;
    private ArrayList<String> texto = new ArrayList<>();
    private ArrayList<Lexema> lexemas = new ArrayList<>();
    String[][] matrizEstados = {
        {"20", "1016", "1018", "1019", "1020", "1021", "1022", "1023", "1024", "1025", "18", "22", "1017", "5", "24", "26", "500", "1015", "1", "500", "500", "2", "1", "28", "0"},
        {"1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1", "1", "1", "1", "1", "1", "500", "1000"},
        {"1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "3", "1001", "1001", "1001", "1001", "2", "10", "500", "1001"},
        {"501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "501", "4", "501", "501", "501"},
        {"1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "4", "10", "500", "1002"},
        {"1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "6", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003"},
        {"7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7"},
        {"7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "8", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7"},
        {"7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "9", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7"},
        {"1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004"},
        {"502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "11", "12", "502", "502", "502", "502", "502", "502", "502", "502", "502", "13", "502", "502", "502"},
        {"502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "13", "502", "502", "502"},
        {"502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "502", "13", "502", "502", "502"},
        {"1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "13", "1026", "1026", "1026"},
        {},
        {},
        {},
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
        "floor",
        "variables"
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
            
            case 1000 ->{
                if(Arrays.asList(palabrasClave).contains(listToString(texto).trim().toLowerCase())){
                    switch(lexema){
                        case "int" -> response = new Lexema("Int", lexema, 2001, line);
                        case "include" -> response = new Lexema("Include", lexema, 2002, line);
                        case "float" -> response = new Lexema("Float", lexema, 2003, line);
                        case "double" -> response = new Lexema("Double", lexema, 2004, line);
                        case "string" -> response = new Lexema("String", lexema, 2005, line);
                        case "char" -> response = new Lexema("Char", lexema, 2006, line);
                        case "function" -> response = new Lexema("Function", lexema, 2007, line);
                        case "return" -> response = new Lexema("Return", lexema, 2008, line);
                        case "call" -> response = new Lexema("Call", lexema, 2009, line);
                        case "if" -> response = new Lexema("If", lexema, 2010, line);
                        case "elif" -> response = new Lexema("Elif", lexema, 2011, line);
                        case "else" -> response = new Lexema("Else", lexema, 2012, line);
                        case "while" -> response = new Lexema("While", lexema, 2013, line);
                        case "for" -> response = new Lexema("For", lexema, 2014, line);
                        case "do" -> response = new Lexema("Do", lexema, 2015, line);
                        case "and" -> response = new Lexema("And", lexema, 2016, line);
                        case "or" -> response = new Lexema("Or", lexema, 2017, line);
                        case "abs" -> response = new Lexema("Abs", lexema, 2018, line);
                        case "sqr" -> response = new Lexema("Sqr", lexema, 2019, line);
                        case "sqrt" -> response = new Lexema("Sqrt", lexema, 2020, line);
                        case "sin" -> response = new Lexema("Sin", lexema, 2021, line);
                        case "sinh" -> response = new Lexema("Sinh", lexema, 2022, line);
                        case "cosh" -> response = new Lexema("Cosh", lexema, 2023, line);
                        case "cos" -> response = new Lexema("Cos", lexema, 2024, line);
                        case "tang" -> response = new Lexema("Tang", lexema, 2025, line);
                        case "tanh" -> response = new Lexema("Tanh", lexema, 2026, line);
                        case "atang" -> response = new Lexema("Atang", lexema, 2027, line);
                        case "asin" -> response = new Lexema("Asin", lexema, 2028, line);
                        case "acos" -> response = new Lexema("Acos", lexema, 2029, line);
                        case "log" -> response = new Lexema("Log", lexema, 2030, line);
                        case "exponential" -> response = new Lexema("Exponential", lexema, 2031, line);
                        case "chr" -> response = new Lexema("Chr", lexema, 2032, line);
                        case "length" -> response = new Lexema("Length", lexema, 2033, line);
                        case "printf" -> response = new Lexema("Printf", lexema, 2034, line);
                        case "scanf" -> response = new Lexema("Scanf", lexema, 2035, line);
                        case "pow" -> response = new Lexema("Pow", lexema, 2036, line);
                        case "cbrt" -> response = new Lexema("Cbrt", lexema, 2037, line);
                        case "fact" -> response = new Lexema("Fact", lexema, 2038, line);
                        case "round" -> response = new Lexema("Round", lexema, 2039, line);
                        case "trunc" -> response = new Lexema("Trunc", lexema, 2040, line);
                        case "minimal" -> response = new Lexema("Minimal", lexema, 2041, line);
                        case "maximal" -> response = new Lexema("Maximal", lexema, 2042, line);
                        case "floor" -> response = new Lexema("Floor", lexema, 2043, line);
                        case "variables" -> response = new Lexema("Variables", lexema, 2044, line);
                        default -> response = new Lexema("Invalid", lexema, -1, line);
                    }
                }else{
                    response = new Lexema("Identificador", lexema, estado, line);
                }
            }
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
            case 1004 ->
                response = new Lexema("Comentario", lexema, estado, line);
        }
        return response;
    }

    public ArrayList<Lexema> analizar(String codigo) {
        initMapColumns();
        codigo = codigo.concat(" ").replaceAll("\t", "");
        while (apuntador != (codigo.length())) {
            char actual = codigo.charAt(apuntador);
            if ((int) actual == 10) {
                line++;
                actual = ' ';
            }
            apuntador++;
            texto.add(String.valueOf(actual));
            try {
                columna = Character.isLetter(actual) ? 18 : (Character.isDigit(actual) ? 21 : mapColumns.get(String.valueOf(actual)));
            } catch (Exception ex) {
                columna = -1;
            }
            if (columna != -1) {
                try {
                    if ((estado == 2 || estado == 4) && actual == 'E') {
                        estado = 10;
                    } else {
                        estado = Integer.parseInt(matrizEstados[estado][columna]);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    line--;
                    lexemas.add(new Lexema("Error de sintaxis", listToString(texto), 500, line));
                    estado = 0;
                    texto.clear();
                    columna = 0;
                    apuntador--;
                }
                if (estado >= 1000) {
                    if (!listToString(texto).contains("E") && (estado == 1027 || estado == 1028) && listToString(texto).contains("+")) {
                        estado = 1005;
                    } else if (!listToString(texto).contains("E") && (estado == 1027 || estado == 1028) && listToString(texto).contains("-")) {
                        estado = 1009;
                    }
                    if (!listToString(texto).endsWith(" ") && estado < 1015 || (!listToString(texto).endsWith(" ") && estado == 1026)) {
                        apuntador--;
                        texto.remove(texto.size() - 1);
                    }
                    lexemas.add(processFinalStates(estado, listToString(texto).replace(" ", ""), line));
                    estado = 0;
                    texto.clear();
                    columna = 0;
                }
            }else{
                lexemas.add(new Lexema("Error de sintaxis", listToString(texto), 500, line));
                estado = 0;
                texto.clear();
                columna = 0;
            }

        }
        return lexemas;
    }
    
    public ArrayList<Lexema> deleteAllComments(ArrayList<Lexema> data){
        Iterator<Lexema> i = data.iterator();
        while(i.hasNext()){
            if(i.next().getState() == 1004){
                i.remove();
            }
        }
        return data;
    }
    
    public static void main(String[] args) {
        ArrayList<Lexema> list = new Lexico().analizar("10E12");
        list.forEach(a ->{
            System.out.println(a);
        });
    }

}
