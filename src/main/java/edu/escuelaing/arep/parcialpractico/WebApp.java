package edu.escuelaing.arep.parcialpractico;

import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.Arrays;

import static spark.Spark.*;

public class WebApp {

    private static int[] lista ;

    public static void main(String[] args) {
        port(getPort());

        get("/", (req, res) -> index(req, res));
        get("/answer", (req, res) ->{
            String set1 = req.queryParams("input");
            lista = inputToDouble(set1);
            ListOperations.mergeSort(lista,lista.length);
            return Arrays.toString(lista);
        });

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
                "      <p>This web application will sort the list that you enter\n\n</p>\n" +
                "       <form action=\"/answer\">\n" +
                "           Enter the numbers:<br>\n" +
                "           <input type=\"text\" placeholder=\"Ex: 1 2 3 4 5\" name=\"input\" ><br>\n" +
                "           <input type=\"submit\" value=\"sort\">\n" +
                "       </form>" +
                "</body></html>";
        return indexHTML;
    }

    public static int[] inputToDouble(String set) {
        ArrayList<Integer> lista2 = new ArrayList<>();
        for (String str : set.split(" ")) {
            int var = Integer.parseInt(str);
            lista2.add(var);
        }
        lista = new int[lista2.size()];
        for (int i = 0; i < lista2.size(); i++){
            lista[i] = lista2.get(i);
        }
        return lista;
    }
}

