/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorSintactico;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 000093883
 */
public class Gramatica {

    public static Map<String, Produccion> gramatica = new LinkedHashMap<>();
    public static LinkedHashSet<String> noTerminales = new LinkedHashSet<>();
    public static LinkedHashSet<String> terminales = new LinkedHashSet<>();

    public static void initNoTerminales() {
        // Agregar los símbolos no terminales a noTerminales
        noTerminales.add("P");
        noTerminales.add("INCLUDE");
        noTerminales.add("CONSTANTES");
        noTerminales.add("VARIABLES");
        noTerminales.add("FUNCION");
        noTerminales.add("MAIN");
        noTerminales.add("VARIABLES_PRIMA");
        noTerminales.add("LISTA_VARIABLES");
        noTerminales.add("LISTA_VARIABLES_PRIMA");
        noTerminales.add("TIPO");
        noTerminales.add("DIMENSION");
        noTerminales.add("FUNCION");
        noTerminales.add("PROCEDURE'");
        noTerminales.add("PARAMETROS");
        noTerminales.add("RETURN");
        noTerminales.add("BLOQUE");
        noTerminales.add("ESTATUTOS");
        noTerminales.add("ESTATUTO");
        noTerminales.add("ASIGNACION");
        noTerminales.add("CALL_FUNCTION");
        noTerminales.add("BUILD_IN_FUNCTIONS");
        noTerminales.add("IMPRESION");
        noTerminales.add("LISTA");
        noTerminales.add("LISTA_ELEMENTO");
        noTerminales.add("LISTA_ELEMENTO_PRIMA");
        noTerminales.add("IF");
        noTerminales.add("ELIF");
        noTerminales.add("WHILE");
        noTerminales.add("FOR");
        noTerminales.add("DO");
        noTerminales.add("SIGNO");
        noTerminales.add("EXP_BOOLEANA");
        noTerminales.add("EXPB'");
        noTerminales.add("TERMB");
        noTerminales.add("TERMB'");
        noTerminales.add("EXP");
        noTerminales.add("EXP'");
        noTerminales.add("TERM");
        noTerminales.add("TERM'");
        noTerminales.add("FACTOR");
        noTerminales.add("FUNCT");
        noTerminales.add("OPER"); 
    }

    public static void initTerminales() {
        terminales.add("#");
        terminales.add("include");
        terminales.add("identificador");
        terminales.add(":=");
        terminales.add(";");
        terminales.add("int");
        terminales.add("float");
        terminales.add("double");
        terminales.add("string");
        terminales.add("char");
        terminales.add("[");
        terminales.add("numero");
        terminales.add("]");
        terminales.add("function");
        terminales.add("(");
        terminales.add(")");
        terminales.add("{");
        terminales.add("}");
        terminales.add("call");
        terminales.add("abs");
        terminales.add("sqr");
        terminales.add("sqrt");
        terminales.add("sin");
        terminales.add("sinh");
        terminales.add("cosh");
        terminales.add("cos");
        terminales.add("tang");
        terminales.add("tangh");
        terminales.add("atang");
        terminales.add("asin");
        terminales.add("acos");
        terminales.add("log");
        terminales.add("exponential");
        terminales.add("chr");
        terminales.add("float");
        terminales.add("length");
        terminales.add("printf");
        terminales.add("scanf");
        terminales.add("pow");
        terminales.add("cbrt");
        terminales.add("fact");
        terminales.add("round");
        terminales.add("trunc");
        terminales.add("minimal");
        terminales.add("maximal");
        terminales.add("floor");
        terminales.add("id");
        terminales.add("numero");
        terminales.add("texto");
        terminales.add("if");
        terminales.add("elif");
        terminales.add("else");
        terminales.add("while");
        terminales.add("for");
        terminales.add("do");
        terminales.add("++");
        terminales.add("--");
        terminales.add("and");
        terminales.add("or");
        terminales.add(">");
        terminales.add("<");
        terminales.add(">=");
        terminales.add("<=");
        terminales.add("=");
        terminales.add(","); 
        terminales.add("return"); 
    }

    public static void initGramatica() {
//        gramatica.put("E", new Produccion(Arrays.asList("T E'"), 1));
//        gramatica.put("E'", new Produccion(Arrays.asList("+ T E'", "null"), 2));
//        gramatica.put("T", new Produccion(Arrays.asList("F T'"), 3));
//        gramatica.put("T'", new Produccion(Arrays.asList("* F T'", "null"), 4));
//        gramatica.put("F", new Produccion(Arrays.asList("( E )", "id"), 5));
//
//        terminales.add("+");
//        terminales.add("*");
//        terminales.add("(");
//        terminales.add(")");
//        terminales.add("id");
//
//        noTerminales.add("E");
//        noTerminales.add("E'");
//        noTerminales.add("T");
//        noTerminales.add("T'");
//        noTerminales.add("F");
        gramatica.put("P", new Produccion(Arrays.asList(new ListedProduction("INCLUDE CONSTANTES VARIABLES FUNCION MAIN", 1))));
        //Include
        gramatica.put("INCLUDE", new Produccion(Arrays.asList(new ListedProduction("# include < identificador >", 2))));
        //Constantes
        gramatica.put("CONSTANTES", new Produccion(Arrays.asList(
                new ListedProduction("identificador := EXP CONSTANTES", 3),
                new ListedProduction(null, 4))));
        //Variables
        gramatica.put("VARIABLES", new Produccion(Arrays.asList(
                new ListedProduction("LISTA_VARIABLES : TIPO VARIABLES_PRIMA", 5))));
        gramatica.put("VARIABLES_PRIMA", new Produccion(Arrays.asList(
                new ListedProduction("; VARIABLES", 6),
                new ListedProduction(null, 7))));
        gramatica.put("LISTA_VARIABLES", new Produccion(Arrays.asList(new ListedProduction("identificador LISTA_VARIABLES_PRIMA", 8))));
        gramatica.put("LISTA_VARIABLES_PRIMA", new Produccion(Arrays.asList(
                new ListedProduction(", LISTA_VARIABLES", 9),
                new ListedProduction(null, 10))));
        gramatica.put("TIPO", new Produccion(Arrays.asList(
                new ListedProduction("int DIMENSION", 11),
                new ListedProduction("float DIMENSION", 12),
                new ListedProduction("double DIMENSION", 13),
                new ListedProduction("string DIMENSION", 14),
                new ListedProduction("char DIMENSION", 15))));
        gramatica.put("DIMENSION", new Produccion(Arrays.asList(
                new ListedProduction("[ numero ] DIMENSION", 16),
                new ListedProduction(null, 17))));
        //Function
        gramatica.put("FUNCION", new Produccion(Arrays.asList(
                new ListedProduction("function identificador (PARAMETROS) BLOQUE RETURN PROCEDURE'", 18),
                new ListedProduction(null, 19))));
        gramatica.put("PROCEDURE'", new Produccion(Arrays.asList(
                new ListedProduction("FUNCION", 20),
                new ListedProduction(null, 21))));
        gramatica.put("PARAMETROS", new Produccion(Arrays.asList(
                new ListedProduction("VARIABLES", 22),
                new ListedProduction(null, 23))));
        gramatica.put("RETURN", new Produccion(Arrays.asList(new ListedProduction("return identificador", 24))));
        //Main
        gramatica.put("MAIN", new Produccion(Arrays.asList(new ListedProduction("{ ESTATUTOS }", 25))));
        //Bloque de estatutos
        gramatica.put("BLOQUE", new Produccion(Arrays.asList(new ListedProduction("{ ESTATUTOS }", 26))));
        //Seecion de estatutos
        gramatica.put("ESTATUTOS", new Produccion(Arrays.asList(
                new ListedProduction("ESTATUTO ; ESTATUTOS", 27),
                new ListedProduction(null, 28))));
        //Estatuto
        gramatica.put("ESTATUTO", new Produccion(Arrays.asList(
                new ListedProduction("ASIGNACION", 29),
                new ListedProduction("CALL_FUNCTION", 30),
                new ListedProduction("WHILE", 31),
                new ListedProduction("IF", 32),
                new ListedProduction("FOR", 33),
                new ListedProduction("DO", 34),
                new ListedProduction("BUILD_IN_FUNCTIONS", 35))));
        gramatica.put("ASIGNACION", new Produccion(Arrays.asList(new ListedProduction("identificador = EXP", 36))));
        gramatica.put("CALL_FUNCTION", new Produccion(Arrays.asList(new ListedProduction("call identificador ( PARAMETRO )", 37))));
        gramatica.put("BUILD_IN_FUNCTIONS", new Produccion(Arrays.asList(
                new ListedProduction("abs", 38),
                new ListedProduction("sqr", 39),
                new ListedProduction("sqrt", 40),
                new ListedProduction("sin", 41),
                new ListedProduction("sinh", 42),
                new ListedProduction("cosh", 43),
                new ListedProduction("cos", 44),
                new ListedProduction("tang", 45),
                new ListedProduction("tangh", 46),
                new ListedProduction("atang", 47),
                new ListedProduction("asin", 48),
                new ListedProduction("acos", 49),
                new ListedProduction("log", 50),
                new ListedProduction("exponential", 51),
                new ListedProduction("chr", 52),
                new ListedProduction("float", 53),
                new ListedProduction("length", 54),
                new ListedProduction("printf", 55),
                new ListedProduction("scanf", 56),
                new ListedProduction("pow", 57),
                new ListedProduction("cbrt", 58),
                new ListedProduction("fact", 59),
                new ListedProduction("round", 60),
                new ListedProduction("trunc", 61),
                new ListedProduction("minimal", 62),
                new ListedProduction("maximal", 63),
                new ListedProduction("floor", 64))));
        gramatica.put("IMPRESION", new Produccion(Arrays.asList(
                new ListedProduction("número IMPRESION_PRIMA", 65),
                new ListedProduction("texto IMPRESION_PRIMA", 66))));
        gramatica.put("IMPRESION_PRIMA", new Produccion(Arrays.asList(
                new ListedProduction(", IMPRESION", 67),
                new ListedProduction(null, 68))));
        gramatica.put("LISTA", new Produccion(Arrays.asList(
                new ListedProduction("[ LISTA_ELEMENTO ]", 69))));
        gramatica.put("LISTA_ELEMENTO", new Produccion(Arrays.asList(
                new ListedProduction("numero LISTA_ELEMENTO_PRIMA", 70))));
        gramatica.put("LISTA_ELEMENTO_PRIMA", new Produccion(Arrays.asList(
                new ListedProduction(", LISTA_ELEMENTO", 71),
                new ListedProduction(null, 72))));
        gramatica.put("IF", new Produccion(Arrays.asList(
                new ListedProduction("if EXP_BOOLEANA BLOQUE ELIF", 73))));
        gramatica.put("ELIF", new Produccion(Arrays.asList(
                new ListedProduction("elif EXP_BOOLEANA BLOQUE ELIF", 74),
                new ListedProduction("else BLOQUE", 75),
                new ListedProduction(null, 76))));
        gramatica.put("WHILE", new Produccion(Arrays.asList(
                new ListedProduction("while EXP_BOOLEANA BLOQUE", 77))));
        gramatica.put("FOR", new Produccion(Arrays.asList(
                new ListedProduction("for [ identificador = EXP ; identificador OPERADOR EXP ; identificador SIGNO ] BLOQUE", 78))));
        gramatica.put("DO", new Produccion(Arrays.asList(
                new ListedProduction("do BLOQUE while EXP_BOOLEANA", 79))));
        gramatica.put("SIGNO", new Produccion(Arrays.asList(
                new ListedProduction("++", 80),
                new ListedProduction("--", 81))));
        gramatica.put("EXP_BOOLEANA", new Produccion(Arrays.asList(
                new ListedProduction("TERMB EXPB'", 82))));
        gramatica.put("EXPB'", new Produccion(Arrays.asList(
                new ListedProduction("and TERMB EXPB'", 83),
                new ListedProduction("or TERMB EXPB'", 84),
                new ListedProduction(null, 85))));
        gramatica.put("TERMB", new Produccion(Arrays.asList(
                new ListedProduction("EXP TERMB'", 86),
                new ListedProduction(null, 87))));
        gramatica.put("TERMB'", new Produccion(Arrays.asList(
                new ListedProduction("OPER EXP TERMB'", 88),
                new ListedProduction(null, 89))));
        gramatica.put("EXP", new Produccion(Arrays.asList(
                new ListedProduction("TERM EXP'", 90),
                new ListedProduction(null, 91))));
        gramatica.put("EXP'", new Produccion(Arrays.asList(
                new ListedProduction("+ TERM EXP'", 92),
                new ListedProduction("- TERM EXP'", 93),
                new ListedProduction(null, 94))));
        gramatica.put("TERM", new Produccion(Arrays.asList(
                new ListedProduction("FACTOR TERM'", 95),
                new ListedProduction(null, 96))));
        gramatica.put("TERM'", new Produccion(Arrays.asList(
                new ListedProduction("* FACTOR TERM'", 97),
                new ListedProduction("/ FACTOR TERM'", 98),
                new ListedProduction(null, 99))));
        gramatica.put("FACTOR", new Produccion(Arrays.asList(
                new ListedProduction("identificador FUNCT", 100),
                new ListedProduction("( EXP_BOOLEANA )", 101))));
        gramatica.put("FUNCT", new Produccion(Arrays.asList(
                new ListedProduction("( PARAMETROS )", 102),
                new ListedProduction(null, 103))));
        gramatica.put("OPER", new Produccion(Arrays.asList(
                new ListedProduction(">", 104),
                new ListedProduction("<", 105),
                new ListedProduction(">=", 106),
                new ListedProduction("<=", 107),
                new ListedProduction("=", 108))));
    }

    public Gramatica() {
        initGramatica();
        initNoTerminales();
        initTerminales();
    }

    void showGramatica() {
        for (Map.Entry<String, Produccion> entry : gramatica.entrySet()) {
            String noTerminal = entry.getKey();
            Produccion producciones = entry.getValue();
            producciones.getProduccion().forEach(x -> {
                System.out.println(noTerminal + " -> " + x);
            });
        }
    }
    public LinkedHashSet<String> getPrimero(String simbolo) {
        LinkedHashSet<String> first = new LinkedHashSet<>();
        Produccion p = gramatica.get(simbolo);
        for(ListedProduction produccion : p.getProduccion()){
            try {
                String[] simbolos = produccion.getSimbolos().split("\\s");
                if(terminales.contains(simbolos[0])){
                    first.add(simbolos[0]);
                }else{
                    LinkedHashSet<String> simbolosIndirectos = getPrimero(simbolos[0]);
                    first.addAll(simbolosIndirectos);
                }
            } catch (NullPointerException e) {
                first.add("null");
            }
            
        }
        return first;
    }

    public static void main(String[] args) {
        var a = Arrays.asList(new String[]{});
        Gramatica g = new Gramatica(); 
        noTerminales.forEach(x->{
            System.out.println(x);
            System.out.println(g.getPrimero(x));
        });
    }
}

/**
 * 
 *PROCEDURE'
[identificador, int, float, double, string, char, {, :, ;, function]
 */
