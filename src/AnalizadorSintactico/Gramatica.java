/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorSintactico;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 000093883
 */
public class Gramatica {

    public static Map<String, List<String>> gramatica = new LinkedHashMap<>();
    public static Set<String> noTerminales = new HashSet<>();
    public static Set<String> terminales = new HashSet<>();

    public static void initGramatica() {
        gramatica.put("E", Arrays.asList("T E'"));
        gramatica.put("E'", Arrays.asList("+ T E'", "null"));
        gramatica.put("T", Arrays.asList("F T'"));
        gramatica.put("T'", Arrays.asList("* F T'", "null"));
        gramatica.put("F", Arrays.asList("( E )", "id"));

        terminales.add("+");
        terminales.add("*");
        terminales.add("(");
        terminales.add(")");
        terminales.add("id");

        noTerminales.add("E");
        noTerminales.add("E'");
        noTerminales.add("T");
        noTerminales.add("T'");
        noTerminales.add("F");

//        gramatica.put("P", Arrays.asList("INCLUDE CONSTANTES VARIABLES FUNCTION MAIN"));
//        //Include
//        gramatica.put("INCLUDE", Arrays.asList("#include <identificador>"));
//        //Constantes
//        gramatica.put("CONSTANTES", Arrays.asList(
//                "identificador := EXP CONSTANTES",
//                null));
//        //Variables
//        gramatica.put("VARIABLES", Arrays.asList(
//                "LISTA_VARIABLES : TIPO VARIABLES_PRIMA"));
//        gramatica.put("VARIABLES_PRIMA", Arrays.asList(
//                "; VARIABLES", 
//                null));
//        gramatica.put("LISTA_VARIABLES", Arrays.asList("identificador LISTA_VARIABLES_PRIMA"));
//        gramatica.put("LISTA_VARIABLES_PRIMA", Arrays.asList(
//                ", LISTA_VARIABLES", 
//                null));
//        gramatica.put("TIPO", Arrays.asList(
//                "int DIMENSION", 
//                "float DIMENSION", 
//                "double DIMENSION", 
//                "string DIMENSION", 
//                "char DIMENSION"));
//        gramatica.put("DIMENSION", Arrays.asList(
//                "[ numero ] DIMENSION", 
//                null));
//        //Function
//        gramatica.put("PROCEDURE", Arrays.asList(
//                "TIPO function identificador (PARAMETROS) BLOQUE RETURN PROCEDURE'", 
//                null));
//        gramatica.put("PROCEDURE'", Arrays.asList(
//                "PROCEURE", 
//                null));
//        gramatica.put("PARAMETROS", Arrays.asList(
//                "VARIABLES", 
//                null));
//        gramatica.put("RETURN", Arrays.asList("return identificador"));
//        //Main
//        gramatica.put("MAIN", Arrays.asList("{ ESTATUTOS }"));
//        //Bloque de estatutos
//        gramatica.put("BLOQUE", Arrays.asList("{ ESTATUTOS }"));
//        //Seecion de estatutos
//        gramatica.put("ESTATUTOS", Arrays.asList(
//                "ESTATUTO ; ESTATUTOS", 
//                null));
//        //Estatuto
//        gramatica.put("ESTATUTO", Arrays.asList(
//                "ASIGNACION", 
//                "CALL_FUNCTION", 
//                "WHILE", 
//                "IF", 
//                "FOR", 
//                "DO", 
//                "BUILD_IN_FUNTIONS"));
//        gramatica.put("ASIGNACION", Arrays.asList("identificador = EXP"));
//        gramatica.put("CALL_FUNCTION", Arrays.asList("call identificador ( PARAMETRO )"));
//        gramatica.put("BUILD_IN_FUNCTIONS", Arrays.asList(
//            "abs(identificador)",
//            "sqr(EXP)",
//            "sqrt(EXP)",
//            "sin(EXP)",
//            "sinh(EXP)",
//            "cosh(EXP)",
//            "cos(EXP)",
//            "tang(EXP)",
//            "tangh(EXP)",
//            "atang(EXP)",
//            "asin(EXP)",
//            "acos(EXP)",
//            "log(EXP)",
//            "exponential(EXP)",
//            "chr(numero)",
//            "float(texto)",
//            "length(identificador)",
//            "printf(IMPRESION)",
//            "scanf()",
//            "pow(EXP)",
//            "cbrt(EXP)",
//            "fact(EXP)",
//            "round(EXP)",
//            "trunc(EXP)",
//            "minimal(LISTA)",
//            "maximal(LISTA)",
//            "floor(EXP)"
//        ));
//        gramatica.put("IMPRESION", Arrays.asList(
//            "número IMPRESION_PRIMA",
//            "texto IMPRESION_PRIMA"
//        )); 
//        gramatica.put("IMPRESION_PRIMA", Arrays.asList(
//            ", IMPRESION",
//            null
//        )); 
//        gramatica.put("LISTA", Arrays.asList(
//            "[LISTA_ELEMENTO]"
//        )); 
//        gramatica.put("LISTA_ELEMENTO", Arrays.asList(
//            "numero LISTA_ELEMENTO_PRIMA"
//        )); 
//        gramatica.put("LISTA_ELEMENTO_PRIMA", Arrays.asList(
//            ", LISTA_ELEMENTO",
//            null
//        )); 
//        gramatica.put("IF", Arrays.asList(
//            "if EXP_BOOLEANA BLOQUE ELIF"
//        )); 
//        gramatica.put("ELIF", Arrays.asList(
//            "elif EXP_BOOLEANA BLOQUE ELIF",
//            "else BLOQUE",
//            null
//        )); 
//        gramatica.put("WHILE", Arrays.asList(
//            "while EXP_BOOLEANA BLOQUE"
//        )); 
//        gramatica.put("FOR", Arrays.asList(
//            "for [identificador=EXP; identificador OPERADOR EXP; identificador SIGNO] BLOQUE"
//        )); 
//        gramatica.put("DO", Arrays.asList(
//            "do BLOQUE while EXP_BOOLEANA"
//        )); 
//        gramatica.put("SIGNO", Arrays.asList(
//            "++",
//            "--"
//        )); 
//        gramatica.put("EXP_BOOLEANA", Arrays.asList(
//            "TERMB EXPB'"
//        )); 
//        gramatica.put("EXPB'", Arrays.asList(
//            "and TERMB EXPB'",
//            "or TERMB EXPB'",
//            null
//        )); 
//        gramatica.put("TERMB", Arrays.asList(
//            "EXP TERMB'",
//            null
//        )); 
//        gramatica.put("TERMB'", Arrays.asList(
//            "OPER EXP TERMB'",
//            null
//        )); 
//        gramatica.put("EXP", Arrays.asList(
//            "TERM EXP'",
//            null
//        )); 
//        gramatica.put("EXP'", Arrays.asList(
//            "+ TERM EXP'",
//            "- TERM EXP'",
//            null
//        )); 
//        gramatica.put("TERM", Arrays.asList(
//            "FACTOR TERM'",
//            null
//        )); 
//        gramatica.put("TERM'", Arrays.asList(
//            "* FACTOR TERM'",
//            "/ FACTOR TERM'",
//            null
//        )); 
//        gramatica.put("FACTOR", Arrays.asList(
//            "identificador FUNCT",
//            "(EXP_BOOLEANA)"
//        )); 
//        gramatica.put("FUNCT", Arrays.asList(
//            "( PARAMETROS )",
//            null
//        )); 
//        gramatica.put("OPER", Arrays.asList(
//            ">",
//            "<",
//            ">=",
//            "<=",
//            "="
//        ));
    }

    public Gramatica() {
        initGramatica();
    }

    void showGramatica() {
        for (Map.Entry<String, List<String>> entry : gramatica.entrySet()) {
            String noTerminal = entry.getKey();
            List<String> producciones = entry.getValue();
            for (String produccion : producciones) {
                System.out.println(noTerminal + " -> " + produccion);
            }
        }
    }

    public Set<String> getFirst(String noTerminal) {
        Set<String> firstSet = new HashSet<>();
        List<String> producciones = gramatica.get(noTerminal);
        if (producciones != null) {
            for (String produccion : producciones) {
                String[] simbolos = produccion.split("\\s+");
                for (String simbolo : simbolos) {
                    if (terminales.contains(simbolo) || simbolo.equals("null")) {
                        firstSet.add(simbolo);
                        break;
                    } else {
                        Set<String> firstDelSimbolo = getFirst(simbolo);
                        firstSet.addAll(firstDelSimbolo);
                        if (!firstDelSimbolo.contains(null)) {
                            break;
                        }
                    }
                }
            }
        }
        return firstSet;
    }

    public static void main(String[] args) {
        Gramatica g = new Gramatica();
        g.showGramatica();
        noTerminales.forEach(x ->{
            System.out.println("Mostrando first de " + x);
            Set<String> f = g.getFirst(x);
            f.forEach(y -> System.out.println(y));
        });
    }

}
