package edu.escuelaing.arep.parcialpractico;

import spark.Request;
import spark.Response;

import java.util.ArrayList;

import static spark.Spark.*;

public class WebApp {

    private static ArrayList<Integer> lista = new ArrayList<>();
    private static double mean = 0;
    private static double standardDeviation = 0;

    public static void main(String[] args) {
        port(getPort());

        get("/", (req, res) -> index(req, res));
        get("/answer", (req, res) -> answer(req, res));

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4444;
    }

    public static String index(Request req, Response res) {
        String indexHTML = "<!DOCTYPE html>\n" +
                "<html><head>\n" +
                "      <title>Calculator</title>\n" +
                "   </head><body>\n<h2>Calculator for mean and standard deviation</h2>\n" +
                "      <p>Web application calculator for mean and standard deviation\n\n</p>\n" +
                "       <form action=\"/answer\">\n" +
                "           Enter the numbers:<br>\n" +
                "           <input type=\"text\" placeholder=\"Ex: 1 2 3 4 5\" name=\"input\" ><br>\n" +
                "           <input type=\"submit\" value=\"Calculate\">\n" +
                "       </form>" +
                "</body></html>";
        return indexHTML;
    }

    public static void inputToDouble(String set, ArrayList<Integer> list) {
        for (String str : set.split(" ")) {
            int var = Integer.parseInt(str);
            list.add(var);
        }
    }

    public static String answer(Request req, Response res) {
        String set1 = req.queryParams("input");
        inputToDouble(set1, lista);


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
                "               <td><b>Mean</b></td>\n" +
                "               <td>" + mean + "</td> \n" +
                "           </tr>\n" +
                "           <tr>\n" +
                "               <td><b>Standard Deviation</b></td>\n" +
                "               <td>" + standardDeviation + "</td> \n" +
                "           </tr>\n" +
                "       </table>" +
                "   </body></html>";

        return answerHTML;
    }
}

