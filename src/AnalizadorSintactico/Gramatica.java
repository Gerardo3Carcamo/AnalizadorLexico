/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorSintactico;

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

    public static Map<String, List<String>> gramatica = new LinkedHashMap<>();
    public static Set<String> noTerminales = new LinkedHashSet<>();
    public static Set<String> terminales = new LinkedHashSet<>();

    public static void initNoTerminales() {
        // Agregar los símbolos no terminales a noTerminales
//        noTerminales.add("P");
//        noTerminales.add("INCLUDE");
//        noTerminales.add("CONSTANTES");
//        noTerminales.add("VARIABLES");
//        noTerminales.add("FUNCTION");
//        noTerminales.add("MAIN");
//        noTerminales.add("VARIABLES_PRIMA");
//        noTerminales.add("LISTA_VARIABLES");
//        noTerminales.add("LISTA_VARIABLES_PRIMA");
//        noTerminales.add("TIPO");
//        noTerminales.add("DIMENSION");
//        noTerminales.add("PROCEDURE");
//        noTerminales.add("PROCEDURE'");
//        noTerminales.add("PARAMETROS");
//        noTerminales.add("RETURN");
//        noTerminales.add("BLOQUE");
//        noTerminales.add("ESTATUTOS");
//        noTerminales.add("ESTATUTO");
//        noTerminales.add("ASIGNACION");
//        noTerminales.add("CALL_FUNCTION");
//        noTerminales.add("BUILD_IN_FUNCTIONS");
//        noTerminales.add("IMPRESION");
//        noTerminales.add("LISTA");
//        noTerminales.add("LISTA_ELEMENTO");
//        noTerminales.add("LISTA_ELEMENTO_PRIMA");
//        noTerminales.add("IF");
//        noTerminales.add("ELIF");
//        noTerminales.add("WHILE");
//        noTerminales.add("FOR");
//        noTerminales.add("DO");
//        noTerminales.add("SIGNO");
//        noTerminales.add("EXP_BOOLEANA");
//        noTerminales.add("EXPB'");
//        noTerminales.add("TERMB");
//        noTerminales.add("TERMB'");
//        noTerminales.add("EXP");
//        noTerminales.add("EXP'");
//        noTerminales.add("TERM");
//        noTerminales.add("TERM'");
//        noTerminales.add("FACTOR");
//        noTerminales.add("FUNCT");
//        noTerminales.add("OPER");

        noTerminales.add("E");
        noTerminales.add("E'");
        noTerminales.add("T");
        noTerminales.add("T'");
        noTerminales.add("F");
    }

    public static void initTerminales() {
//        terminales.add("#");
//        terminales.add("include");
//        terminales.add("identificador");
//        terminales.add(":=");
//        terminales.add(";");
//        terminales.add("int");
//        terminales.add("float");
//        terminales.add("double");
//        terminales.add("string");
//        terminales.add("char");
//        terminales.add("[numero]");
//        terminales.add("function");
//        terminales.add("(");
//        terminales.add(")");
//        terminales.add("call");
//        terminales.add("abs(identificador)");
//        terminales.add("sqr(EXP)");
//        terminales.add("sqrt(EXP)");
//        terminales.add("sin(EXP)");
//        terminales.add("sinh(EXP)");
//        terminales.add("cosh(EXP)");
//        terminales.add("cos(EXP)");
//        terminales.add("tang(EXP)");
//        terminales.add("tangh(EXP)");
//        terminales.add("atang(EXP)");
//        terminales.add("asin(EXP)");
//        terminales.add("acos(EXP)");
//        terminales.add("log(EXP)");
//        terminales.add("exponential(EXP)");
//        terminales.add("chr(numero)");
//        terminales.add("float(texto)");
//        terminales.add("length(identificador)");
//        terminales.add("printf(IMPRESION)");
//        terminales.add("scanf()");
//        terminales.add("pow(EXP)");
//        terminales.add("cbrt(EXP)");
//        terminales.add("fact(EXP)");
//        terminales.add("round(EXP)");
//        terminales.add("trunc(EXP)");
//        terminales.add("minimal(LISTA)");
//        terminales.add("maximal(LISTA)");
//        terminales.add("floor(EXP)");
//        terminales.add("id");
//        terminales.add("numero");
//        terminales.add("texto");
//        terminales.add("if");
//        terminales.add("elif");
//        terminales.add("else");
//        terminales.add("while");
//        terminales.add("for");
//        terminales.add("do");
//        terminales.add("++");
//        terminales.add("--");
//        terminales.add("and");
//        terminales.add("or");
//        terminales.add(">");
//        terminales.add("<");
//        terminales.add(">=");
//        terminales.add("<=");
//        terminales.add("=");

        terminales.add("+");
        terminales.add("*");
        terminales.add("(");
        terminales.add(")");
        terminales.add("id");
    }

    public static void initGramatica() {
        gramatica.put("E", Arrays.asList("T E'"));
        gramatica.put("E'", Arrays.asList("+ T E'", "null"));
        gramatica.put("T", Arrays.asList("F T'"));
        gramatica.put("T'", Arrays.asList("* F T'", "null"));
        gramatica.put("F", Arrays.asList("( E )", "id"));
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

        gramatica.put("P", Arrays.asList("INCLUDE CONSTANTES VARIABLES FUNCTION MAIN"));
        //Include
        gramatica.put("INCLUDE", Arrays.asList("# include < identificador >"));
        //Constantes
        gramatica.put("CONSTANTES", Arrays.asList(
                "identificador := EXP CONSTANTES",
                null));
        //Variables
        gramatica.put("VARIABLES", Arrays.asList(
                "LISTA_VARIABLES : TIPO VARIABLES_PRIMA"));
        gramatica.put("VARIABLES_PRIMA", Arrays.asList(
                "; VARIABLES",
                null));
        gramatica.put("LISTA_VARIABLES", Arrays.asList("identificador LISTA_VARIABLES_PRIMA"));
        gramatica.put("LISTA_VARIABLES_PRIMA", Arrays.asList(
                ", LISTA_VARIABLES",
                null));
        gramatica.put("TIPO", Arrays.asList(
                "int DIMENSION",
                "float DIMENSION",
                "double DIMENSION",
                "string DIMENSION",
                "char DIMENSION"));
        gramatica.put("DIMENSION", Arrays.asList(
                "[ numero ] DIMENSION",
                null));
        //Function
        gramatica.put("PROCEDURE", Arrays.asList(
                "TIPO function identificador (PARAMETROS) BLOQUE RETURN PROCEDURE'",
                null));
        gramatica.put("PROCEDURE'", Arrays.asList(
                "PROCEURE",
                null));
        gramatica.put("PARAMETROS", Arrays.asList(
                "VARIABLES",
                null));
        gramatica.put("RETURN", Arrays.asList("return identificador"));
        //Main
        gramatica.put("MAIN", Arrays.asList("{ ESTATUTOS }"));
        //Bloque de estatutos
        gramatica.put("BLOQUE", Arrays.asList("{ ESTATUTOS }"));
        //Seecion de estatutos
        gramatica.put("ESTATUTOS", Arrays.asList(
                "ESTATUTO ; ESTATUTOS",
                null));
        //Estatuto
        gramatica.put("ESTATUTO", Arrays.asList(
                "ASIGNACION",
                "CALL_FUNCTION",
                "WHILE",
                "IF",
                "FOR",
                "DO",
                "BUILD_IN_FUNTIONS"));
        gramatica.put("ASIGNACION", Arrays.asList("identificador = EXP"));
        gramatica.put("CALL_FUNCTION", Arrays.asList("call identificador ( PARAMETRO )"));
        gramatica.put("BUILD_IN_FUNCTIONS", Arrays.asList(
                "abs(identificador)",
                "sqr(EXP)",
                "sqrt(EXP)",
                "sin(EXP)",
                "sinh(EXP)",
                "cosh(EXP)",
                "cos(EXP)",
                "tang(EXP)",
                "tangh(EXP)",
                "atang(EXP)",
                "asin(EXP)",
                "acos(EXP)",
                "log(EXP)",
                "exponential(EXP)",
                "chr(numero)",
                "float(texto)",
                "length(identificador)",
                "printf(IMPRESION)",
                "scanf()",
                "pow(EXP)",
                "cbrt(EXP)",
                "fact(EXP)",
                "round(EXP)",
                "trunc(EXP)",
                "minimal(LISTA)",
                "maximal(LISTA)",
                "floor(EXP)"
        ));
        gramatica.put("IMPRESION", Arrays.asList(
                "número IMPRESION_PRIMA",
                "texto IMPRESION_PRIMA"
        ));
        gramatica.put("IMPRESION_PRIMA", Arrays.asList(
                ", IMPRESION",
                null
        ));
        gramatica.put("LISTA", Arrays.asList(
                "[LISTA_ELEMENTO]"
        ));
        gramatica.put("LISTA_ELEMENTO", Arrays.asList(
                "numero LISTA_ELEMENTO_PRIMA"
        ));
        gramatica.put("LISTA_ELEMENTO_PRIMA", Arrays.asList(
                ", LISTA_ELEMENTO",
                null
        ));
        gramatica.put("IF", Arrays.asList(
                "if EXP_BOOLEANA BLOQUE ELIF"
        ));
        gramatica.put("ELIF", Arrays.asList(
                "elif EXP_BOOLEANA BLOQUE ELIF",
                "else BLOQUE",
                null
        ));
        gramatica.put("WHILE", Arrays.asList(
                "while EXP_BOOLEANA BLOQUE"
        ));
        gramatica.put("FOR", Arrays.asList(
                "for [ identificador = EXP ; identificador OPERADOR EXP ; identificador SIGNO ] BLOQUE"
        ));
        gramatica.put("DO", Arrays.asList(
                "do BLOQUE while EXP_BOOLEANA"
        ));
        gramatica.put("SIGNO", Arrays.asList(
                "++",
                "--"
        ));
        gramatica.put("EXP_BOOLEANA", Arrays.asList(
                "TERMB EXPB'"
        ));
        gramatica.put("EXPB'", Arrays.asList(
                "and TERMB EXPB'",
                "or TERMB EXPB'",
                null
        ));
        gramatica.put("TERMB", Arrays.asList(
                "EXP TERMB'",
                null
        ));
        gramatica.put("TERMB'", Arrays.asList(
                "OPER EXP TERMB'",
                null
        ));
        gramatica.put("EXP", Arrays.asList(
                "TERM EXP'",
                null
        ));
        gramatica.put("EXP'", Arrays.asList(
                "+ TERM EXP'",
                "- TERM EXP'",
                null
        ));
        gramatica.put("TERM", Arrays.asList(
                "FACTOR TERM'",
                null
        ));
        gramatica.put("TERM'", Arrays.asList(
                "* FACTOR TERM'",
                "/ FACTOR TERM'",
                null
        ));
        gramatica.put("FACTOR", Arrays.asList(
                "identificador FUNCT",
                "( EXP_BOOLEANA )"
        ));
        gramatica.put("FUNCT", Arrays.asList(
                "( PARAMETROS )",
                null
        ));
        gramatica.put("OPER", Arrays.asList(
                ">",
                "<",
                ">=",
                "<=",
                "="
        ));
    }

    public Gramatica() {
        initGramatica();
        initNoTerminales();
        initTerminales();
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

    public LinkedHashSet<String> getFirst(String noTerminal) {
        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        List<String> producciones = gramatica.get(noTerminal);
        if (producciones != null) {
            for (String produccion : producciones) {
                if (produccion == null) {
                    firstSet.add(null);
                    continue;
                }
                String[] simbolos = produccion.split("\\s+");
                boolean todosDerivanEnEpsilon = true;
                for (String simbolo : simbolos) {
                    if (terminales.contains(simbolo) || simbolo.equals("null")) {
                        firstSet.add(simbolo);
                        todosDerivanEnEpsilon = false;
                        break;
                    } else {
                        Set<String> firstDelSimbolo = getFirst(simbolo);
                        firstSet.addAll(firstDelSimbolo);
                        if (!firstDelSimbolo.contains(null)) {
                            todosDerivanEnEpsilon = false;
                            break;
                        }
                    }
                }
                if (todosDerivanEnEpsilon) {
                    firstSet.add(null);
                }
            }
        }
        return firstSet;
    }

    public LinkedHashSet<String> getFollow(String noTerminal) {
        return getFollow(noTerminal, new HashSet<>());
    }

    private LinkedHashSet<String> getFollow(String noTerminal, Set<String> visited) {
        LinkedHashSet<String> followSet = new LinkedHashSet<>();

        if (visited.contains(noTerminal)) {
            return followSet;
        }

        visited.add(noTerminal);

        if (noTerminal.equals("E")) {
            followSet.add("EOF");
        }

        for (Map.Entry<String, List<String>> entry : gramatica.entrySet()) {
            String noTerminalActual = entry.getKey();
            List<String> producciones = entry.getValue();
            for (String produccion : producciones) {
                if (produccion != null) {
                    String[] simbolos = produccion.split("\\s+");
                    for (int i = 0; i < simbolos.length; i++) {
                        String simbolo = simbolos[i];
                        if (simbolo.equals(noTerminal)) {
                            for (int j = i + 1; j < simbolos.length; j++) {
                                String siguienteSimbolo = simbolos[j];
                                if (terminales.contains(siguienteSimbolo)) {
                                    followSet.add(siguienteSimbolo);
                                    break;
                                }
                                if (siguienteSimbolo.equals("null")) {
                                    followSet.addAll(getFollow(noTerminalActual, visited));
                                    break;
                                }
                                if (!siguienteSimbolo.equals("null")) {
                                    followSet.addAll(getFirst(siguienteSimbolo));
                                    break;
                                }
                            }
                            if (i == simbolos.length - 1 || simbolos[i + 1].equals("null")) {
                                followSet.addAll(getFollow(noTerminalActual, visited));
                            }
                        }
                    }
                }
            }
        }

        return followSet;
    }

    public static void main(String[] args) {
        Gramatica g = new Gramatica();
//        g.showGramatica();
        noTerminales.forEach(x -> {
            System.out.println("Mostrando first de " + x);
            LinkedHashSet<String> f = g.getFirst(x);
            StringBuilder builder = new StringBuilder();
            builder.append("{ ");
            f.forEach(y -> builder.append(y).append(", "));
            if (builder.toString().length() >= 3) {
                System.out.println(builder.toString().substring(0, builder.length() - 2) + " }");
            } else {
                System.out.println(builder.toString() + " }");
            }
        });
        System.out.println();
        noTerminales.forEach(x -> {
            System.out.println("Mostrando follow de " + x);
            LinkedHashSet<String> f = g.getFollow(x);
            StringBuilder builder = new StringBuilder();
            builder.append("{ ");
            f.forEach(y -> builder.append(y).append(", "));
            if (builder.toString().length() >= 3) {
                System.out.println(builder.toString().substring(0, builder.length() - 2) + " }");
            } else {
                System.out.println(builder.toString() + " }");
            }
        });
    }

}
