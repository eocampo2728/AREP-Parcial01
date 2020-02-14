package edu.escuelaing.arep.parcialpractico;

import spark.Request;
import spark.Response;

import java.util.ArrayList;

import static spark.Spark.*;

public class WebApp {

    private static int[] lista ;

    public static void main(String[] args) {
        port(getPort());

        get("/", (req, res) -> index(req, res));
        get("/answer", (req, res) -> answer(req, res));

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

    public static String index(Request req, Response res) {
        String indexHTML = "<!DOCTYPE html>\n" +
                "<html>ListOperations<head>\n" +
                "      <title>List Operations</title>\n" +
                "   </head><body>\n<h2></h2>\n" +
                "      <p>Web application calculator for mean and standard deviation\n\n</p>\n" +
                "       <form action=\"/answer\">\n" +
                "           Enter the numbers:<br>\n" +
                "           <input type=\"text\" placeholder=\"Ex: 1 2 3 4 5\" name=\"input\" ><br>\n" +
                "           <input type=\"submit\" value=\"Calculate\">\n" +
                "       </form>" +
                "</body></html>";
        return indexHTML;
    }

    public static int[] inputToDouble(String set, int[] list) {
        ArrayList<Integer> lista2 = new ArrayList<>();
        for (String str : set.split(" ")) {
            int var = Integer.parseInt(str);
            lista2.add(var);
        }
        list = new int[lista2.size()];
        for (int i = 0; i < lista2.size(); i++){
            list[i] = lista2.get(i);
        }
        return list;
    }

    public static String answer(Request req, Response res) {
        String set1 = req.queryParams("input");
        lista = inputToDouble(set1, lista);
        ListOperations.mergeSort(lista,lista.length);


        String answerHTML = "<!DOCTYPE html>\n" +
                "<html><head>\n" +
                "      <title>mean and standardD</title>\n" +
                "   </head><body>\n" +
                "      <p><b>Calculo de Datos Estadisticos</b></p>\n" +
                "       <h2>Results</h2>" +
                "       <table style=\"width:30%\">\n" +
                "           <tr>\n" +
                "               <th>Calculation</th>\n" +
                "               <th><b>Answer</b></th> \n" +
                "           </tr>\n" +
                "           <tr>\n" +
                "               <td><b>SortedList</b></td>\n" +
                "               <td>" + lista + "</td> \n" +
                "           </tr>\n" +
                "       </table>" +
                "   </body></html>";

        return answerHTML;
    }
}

