/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorSintactico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 000093883
 */
public class Gramatica {

    public static Map<String, Produccion> gramatica = new LinkedHashMap<>();
    public static LinkedHashSet<String> noTerminales = new LinkedHashSet<>();
    public static LinkedHashSet<String> terminales = new LinkedHashSet<>();
    private static final String FILE_EXTENSION = ".txt";
    private final int LIMIT = 100;

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
        noTerminales.add("IMPRESION_PRIMA");
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
        terminales.add("/");
        terminales.add("*");
        terminales.add("+");
        terminales.add("-");
    }

    public static void initGramatica() {
//        gramatica.put("E", new Produccion(Arrays.asList(new ListedProduction("T E'", 1))));
//        gramatica.put("E'", new Produccion(Arrays.asList(new ListedProduction("+ T E'", 2), new ListedProduction("null", 3))));
//        gramatica.put("T", new Produccion(Arrays.asList(new ListedProduction("F T'", 4))));
//        gramatica.put("T'", new Produccion(Arrays.asList(new ListedProduction("* F T'", 5), new ListedProduction("null", 6))));
//        gramatica.put("F", new Produccion(Arrays.asList(new ListedProduction("( E )", 7), new ListedProduction("id", 8))));
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
        gramatica.put("P", new Produccion(Arrays.asList(
            new ListedProduction("INCLUDE CONSTANTES VARIABLES FUNCION MAIN", 1)
        )));
        gramatica.put("INCLUDE", new Produccion(Arrays.asList(
            new ListedProduction("# include < identificador >", 2)
        )));
        gramatica.put("CONSTANTES", new Produccion(Arrays.asList(
            new ListedProduction("identificador := EXP CONSTANTES", 3),
            new ListedProduction("null", 4)
        )));
        gramatica.put("VARIABLES", new Produccion(Arrays.asList(
            new ListedProduction("LISTA_ VARIABLES : TIPO VARIABLES_PRIMA", 5)
        )));
        gramatica.put("VARIABLES_PRIMA", new Produccion(Arrays.asList(
            new ListedProduction("; VARIABLES", 6),
            new ListedProduction("null", 7)
        )));
        gramatica.put("LISTA_VARIABLES", new Produccion(Arrays.asList(
            new ListedProduction("identificador LISTA_VARIABLES_PRIMA", 8)
        )));
        gramatica.put("LISTA_VARIABLES_PRIMA", new Produccion(Arrays.asList(
            new ListedProduction(", LISTA_VARIABLES", 9),
            new ListedProduction("null", 10)
        )));
        gramatica.put("TIPO", new Produccion(Arrays.asList(
            new ListedProduction("int DIMENSION", 11),
            new ListedProduction("float DIMENSION", 12),
            new ListedProduction("double DIMENSION", 13),
            new ListedProduction("string DIMENSION", 14),
            new ListedProduction("char DIMENSION", 15)
        )));
        gramatica.put("DIMENSION", new Produccion(Arrays.asList(
            new ListedProduction("[ numero ] DIMENSION", 16),
            new ListedProduction("null", 17)
        )));
        gramatica.put("FUNCION", new Produccion(Arrays.asList(
            new ListedProduction("TIPO function identificador ( PARAMETROS ) BLOQUE RETURN PROCEDURE'", 18),
            new ListedProduction("null", 19)
        )));
        gramatica.put("PROCEDURE'", new Produccion(Arrays.asList(
            new ListedProduction("FUNCION", 20),
            new ListedProduction("null", 21)
        )));
        gramatica.put("PARAMETROS", new Produccion(Arrays.asList(
            new ListedProduction("VARIABLES", 22),
            new ListedProduction("null", 23)
        )));
        gramatica.put("RETURN", new Produccion(Arrays.asList(
            new ListedProduction("return identificador", 24)
        )));
        gramatica.put("MAIN", new Produccion(Arrays.asList(
            new ListedProduction("{ ESTATUTOS }", 25)
        )));
        gramatica.put("BLOQUE", new Produccion(Arrays.asList(
            new ListedProduction("{ ESTATUTOS }", 26)
        )));
        gramatica.put("ESTATUTOS", new Produccion(Arrays.asList(
            new ListedProduction("ESTATUTO ; ESTATUTOS", 27),
            new ListedProduction("null", 28)
        )));
        gramatica.put("ESTATUTO", new Produccion(Arrays.asList(
            new ListedProduction("ASIGNACION", 29),
            new ListedProduction("CALL_FUNCTION", 30),
            new ListedProduction("WHILE", 31),
            new ListedProduction("IF", 32),
            new ListedProduction("FOR", 33),
            new ListedProduction("DO", 34),
            new ListedProduction("BUILD_IN_FUNCTIONS", 35)
        )));
        gramatica.put("ASIGNACION", new Produccion(Arrays.asList(
            new ListedProduction("identificador = EXP", 36)
        )));
        gramatica.put("CALL_FUNCTION", new Produccion(Arrays.asList(
            new ListedProduction("call identificador ( PARAMETRO )", 37)
        )));
        gramatica.put("BUILD_IN_FUNCTIONS", new Produccion(Arrays.asList(
            new ListedProduction("abs ( identificador )", 38),
            new ListedProduction("sqr ( EXP )", 39),
            new ListedProduction("sqrt ( EXP )", 40),
            new ListedProduction("sin ( EXP )", 41),
            new ListedProduction("sinh ( EXP )", 42),
            new ListedProduction("cosh ( EXP )", 43),
            new ListedProduction("cos ( EXP )", 44),
            new ListedProduction("tang ( EXP )", 45),
            new ListedProduction("atang ( EXP )", 46),
            new ListedProduction("asin ( EXP )", 47),
            new ListedProduction("acos ( EXP )", 48),
            new ListedProduction("log ( EXP )", 49),
            new ListedProduction("exponential ( EXP )", 50),
            new ListedProduction("chr ( numero )", 51),
            new ListedProduction("float ( texto )", 52),
            new ListedProduction("length ( identificador )", 53),
            new ListedProduction("printf ( IMPRESION )", 54),
            new ListedProduction("scanf ( )", 55),
            new ListedProduction("pow ( EXP )", 56),
            new ListedProduction("cbrt ( EXP )", 57),
            new ListedProduction("fact ( EXP )", 58),
            new ListedProduction("round ( EXP )", 59),
            new ListedProduction("trunc ( EXP )", 60),
            new ListedProduction("minimal ( LISTA )", 61),
            new ListedProduction("maximal ( LISTA )", 62),
            new ListedProduction("floor ( EXP )", 63)
        )));
        gramatica.put("IMPRESION", new Produccion(Arrays.asList(
            new ListedProduction("numero IMPRESION_PRIMA", 64),
            new ListedProduction("texto IMPRESION_PRIMA", 65)
        )));
        gramatica.put("IMPRESION_PRIMA", new Produccion(Arrays.asList(
            new ListedProduction(", IMPRESION", 66),
            new ListedProduction("null", 67)
        )));
        gramatica.put("LISTA", new Produccion(Arrays.asList(
            new ListedProduction("[ LISTA_ELEMENTO ]", 68)
        )));
        gramatica.put("LISTA_ELEMENTO", new Produccion(Arrays.asList(
            new ListedProduction("numero , LISTA_ELEMENTO_PRIMA", 69)
        )));
        gramatica.put("LISTA_ELEMENTO_PRIMA", new Produccion(Arrays.asList(
            new ListedProduction(", LISTA_ELEMENTO", 70),
            new ListedProduction("null", 71)
        )));
        gramatica.put("IF", new Produccion(Arrays.asList(
            new ListedProduction("if EXP_BOOLEANA BLOQUE ELIF", 72)
        )));
        gramatica.put("ELIF", new Produccion(Arrays.asList(
            new ListedProduction("elif EXP_BOOLEANA BLOQUE ELIF", 73),
            new ListedProduction("else BLOQUE", 74),
            new ListedProduction("null", 75)
        )));
        gramatica.put("WHILE", new Produccion(Arrays.asList(
            new ListedProduction("while EXP_BOOLEANA BLOQUE", 76)
        )));
        gramatica.put("FOR", new Produccion(Arrays.asList(
            new ListedProduction("for [ identificador = EXP ; identificador OPER EXP ; identificador SIGNO ] BLOQUE", 77)
        )));
        gramatica.put("DO", new Produccion(Arrays.asList(
            new ListedProduction("do BLOQUE while EXP_BOOLEANA", 78)
        )));
        gramatica.put("SIGNO", new Produccion(Arrays.asList(
            new ListedProduction("++", 79),
            new ListedProduction("--", 80)
        )));
        gramatica.put("EXP_BOOLEANA", new Produccion(Arrays.asList(
            new ListedProduction("TERMB EXPB'", 81)
        )));
        gramatica.put("EXPB'", new Produccion(Arrays.asList(
            new ListedProduction("and TERMB EXPB'", 82),
            new ListedProduction("or TERMB EXPB'", 83),
            new ListedProduction("null", 84)
        )));
        gramatica.put("TERMB", new Produccion(Arrays.asList(
            new ListedProduction("FACTOR TERM'", 85)
        )));
        gramatica.put("TERMB'", new Produccion(Arrays.asList(
            new ListedProduction("OPER EXP TERMB'", 86),
            new ListedProduction("null", 87)
        )));
        gramatica.put("EXP", new Produccion(Arrays.asList(
            new ListedProduction("TERM EXP'", 88)
        )));
        gramatica.put("EXP'", new Produccion(Arrays.asList(
            new ListedProduction("+ TERM EXP'", 89),
            new ListedProduction("- TERM EXP'", 90),
            new ListedProduction("null", 91)
        )));
        gramatica.put("TERM", new Produccion(Arrays.asList(
            new ListedProduction("FACTOR TERM'", 92)
        )));
        gramatica.put("TERM'", new Produccion(Arrays.asList(
            new ListedProduction("* FACTOR TERM'", 93),
            new ListedProduction("/ FACTOR TERM'", 94),
            new ListedProduction("null", 95)
        )));
        gramatica.put("FACTOR", new Produccion(Arrays.asList(
            new ListedProduction("identificador FUNCT", 96),
            new ListedProduction("( EXP_BOOLEANA )", 97)
        )));
        gramatica.put("FUNCT", new Produccion(Arrays.asList(
            new ListedProduction("( PARAMETROS )", 98),
            new ListedProduction("null", 99)
        )));
        gramatica.put("OPER", new Produccion(Arrays.asList(
            new ListedProduction(">", 100),
            new ListedProduction("<", 101),
            new ListedProduction(">=", 102),
            new ListedProduction("<=", 103),
            new ListedProduction("=", 104)
        )));
    }

    public Gramatica() {
        initGramatica();
        initNoTerminales();
        initTerminales();
    }

    private void showGramatica() {
        for (Map.Entry<String, Produccion> entry : gramatica.entrySet()) {
            String noTerminal = entry.getKey();
            Produccion producciones = entry.getValue();
            producciones.getProduccion().forEach(x -> {
                System.out.println(noTerminal + " -> " + x.toString());
            });
        }
    }

    public boolean getFileFirstSet(String fileName) {
        var path = System.getProperty("user.home") + "/Desktop/";
        File file = new File(path + fileName + FILE_EXTENSION);
        if(file.exists()){
            file.delete();
        }
        try {
            FileWriter wr = new FileWriter(file, true);
            noTerminales.forEach(x -> {
                try {
                    wr.write("\n");

                    wr.write(x + ": [");
                    getFirst(x).forEach(y -> {
                        try {
                            wr.write(y.toString() + ",");
                        } catch (IOException ex) {
                            Logger.getLogger(Gramatica.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    wr.write("]");
                } catch (IOException ex) {
                    Logger.getLogger(Gramatica.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public boolean getFileFollwSet(String fileName) {
        var path = System.getProperty("user.home") + "/Desktop/";
        File file = new File(path + fileName + FILE_EXTENSION);
        if(file.exists()){
            file.delete();
        }
        try {
            FileWriter wr = new FileWriter(file, true);
            noTerminales.forEach(x -> {
                try {
                    wr.write("\n");

                    wr.write(x + ": [");
                    System.out.println(x);
                    getFollow(x).forEach(y -> {
                        try {
                            wr.write(y.toString() + ",");
                        } catch (IOException ex) {
                            Logger.getLogger(Gramatica.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    wr.write("]");
                } catch (IOException ex) {
                    Logger.getLogger(Gramatica.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            visitedSymbols.clear();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    public boolean getNT_TList(String fileName, boolean terminal){
        var path = System.getProperty("user.home") + "/Desktop/";
        File file = new File(path + fileName + FILE_EXTENSION);
        try(FileWriter fw = new FileWriter(file)){
            if(terminal){
                terminales.forEach(x ->{
                    try {
                        fw.write(x + "\n");
                    } catch (IOException ex) {
                        Logger.getLogger(Gramatica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }else{
                noTerminales.forEach(x -> {
                    try {
                        fw.write(x + "\n");
                    } catch (IOException ex) {
                        Logger.getLogger(Gramatica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    private final LinkedList<String> visitedSymbols = new LinkedList<>();

    private int getCountFromSymbol(String noTerminal) {
        int count = 0;
        for (String x : visitedSymbols) {
            if (x.equals(noTerminal)) {
                count++;
            }
        }
        return count;
    }

    private LinkedHashSet<String> getProductions(String noTerminal) {
        LinkedHashSet<String> lista = new LinkedHashSet<>();
        gramatica.forEach((x, y) -> {
            y.getProduccion().forEach(listed -> {
                try {
                    if (listed.getSimbolos() != null) {
                        if (Arrays.asList(listed.getSimbolos().split("\\s")).contains(noTerminal)) {
                            lista.add(x + "->" + listed.getSimbolos() + "->" + listed.getLine());
                        }
                    }
                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                }
            });
        });
        return lista;
    }

    public int getIndex(String[] symbols, String target) {
        int aux = -1;
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i].equals(target)) {
                aux = i;
                break;
            }
        }
        return aux;
    }
    
    private boolean containsNull(LinkedHashSet<First> data){
        final boolean[] flag = new boolean[]{false};
        data.forEach(x -> {
            if(x.getProduccion().equals("null")){
                flag[0] = true;
            }
        });
        return flag[0];
    }
    
    private LinkedHashSet<First> removeIfContainsNullValue(LinkedHashSet<First> data){
        LinkedHashSet<First> aux = new LinkedHashSet<>();
        data.forEach(x ->{
            if(!x.getProduccion().equals("null")) aux.add(x);
        });
        return aux;
    }

    private LinkedHashSet<First> getFollow(String noTerminal) {
        LinkedHashSet<First> result = new LinkedHashSet<>();
        visitedSymbols.add(noTerminal);
        if (getCountFromSymbol(noTerminal) < LIMIT) {
            LinkedHashSet<String> producciones = getProductions(noTerminal);
            producciones.forEach(x -> {
                String[] symbols = x.split("->")[1].split("\\s");
                if (symbols[symbols.length - 1].equals(noTerminal)) {
                    LinkedHashSet<First> simbolosIndirectos = getFollow(x.split("->")[0]);
                    if (simbolosIndirectos != null) {
                        result.addAll(simbolosIndirectos);
                    }
                } else if (!symbols[symbols.length - 1].equals(noTerminal) && noTerminales.contains(symbols[getIndex(symbols, noTerminal) + 1])) {
                    String a = symbols[getIndex(symbols, noTerminal) + 1];
                    LinkedHashSet<First> simbolosIndirectos = getFirst(a);
                    result.addAll(simbolosIndirectos);
                    if (containsNull(simbolosIndirectos)) {
                        try{
                            if(terminales.contains(symbols[getIndex(symbols, noTerminal) + 2])){
                                result.add(new First(symbols[getIndex(symbols, noTerminal) + 2], Integer.parseInt(x.split("->")[0])));
                            }else{
                                String sAux = symbols[getIndex(symbols, noTerminal) + 2];
                                LinkedHashSet<First> list = getFirst(sAux);
                                result.addAll(list);
                            }
                        }catch(Exception ex){
                            try{
                                String sAux = x.split("->")[0];
                                LinkedHashSet<First> f = getFollow(sAux);
                                result.addAll(f);
                            }catch(NullPointerException e){
                                
                            }
                        }
                    }
                } else if (!symbols[symbols.length - 1].equals(noTerminal) && terminales.contains(symbols[getIndex(symbols, noTerminal) + 1])) {
                    result.add(new First(symbols[getIndex(symbols, noTerminal) + 1], Integer.parseInt(x.split("->")[2])));
                }
                if (noTerminal.equals("P") || noTerminal.equals("E")) {
                    result.add(new First("EOF", -1));
                }
            });
            if (noTerminal.equals("P") || noTerminal.equals("E")) {
                result.add(new First("EOF", -1));
            }
            return purgeFollowSet(removeIfContainsNullValue(result));
        } else {
            return null;
        }
    }
    private LinkedHashSet<First> purgeFollowSet(LinkedHashSet<First> data){
        LinkedList<String> symbol = new LinkedList<>();
        LinkedList<Integer> line = new LinkedList<>();
        data.forEach(x ->{
            if(!symbol.contains(x.getProduccion())){
                symbol.add(x.getProduccion());
                line.add(x.getLine());
            }
        });
        LinkedHashSet<First> result = new LinkedHashSet<>();
        for(int i = 0; i < symbol.size(); i++) result.add(new First(symbol.get(i), line.get(i)));
        return result;
    }

    private LinkedHashSet<First> getFirst(String simbolo) {
        LinkedHashSet<First> first = new LinkedHashSet<>();
        Produccion p = gramatica.get(simbolo);
        for (ListedProduction produccion : p.getProduccion()) {
            int line = produccion.getLine();
            try {
                String[] simbolos = produccion.getSimbolos().split("\\s");
                if (terminales.contains(simbolos[0])) {
                    first.add(new First(simbolos[0], line));
                } else {
                    LinkedHashSet<First> simbolosIndirectos = getFirst(simbolos[0]);
                    first.addAll(simbolosIndirectos);
                }
            } catch (NullPointerException e) {
                first.add(new First("null", line));
            }
        }
        return purgeFollowSet(first);
    }

    public static void main(String[] args) {
//        Gramatica g = new Gramatica();
//        g.getFileFirstSet("FirstFile");
//        g.getNT_TList("Terminales", true);
//        g.getNT_TList("No Terminales", false);
//        g.getFileFollwSet("FollowFile");
//        System.out.println(g.getFirst("BLOQUE"));
//            System.out.println(action);
//            System.out.println(g.getFirst(action));
//        });
//        noTerminales.forEach(action -> {
//            System.out.println(action);
//            System.out.println(g.getFollow(action));
//            g.visitedSymbols.clear();
//        });
    }
}
