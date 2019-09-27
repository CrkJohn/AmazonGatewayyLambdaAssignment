package edu.escuelaing.arem.firstWorkshop;

import static spark.Spark.*;
import java.util.*;

import com.google.gson.JsonObject;

import static spark.Spark.*;
import java.util.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.text.*;

public class SparkWebApp {

    private static NumberFormat formatter = new DecimalFormat("#0.00");

    public static LinkedList<Double> numbers;
    public static double amountNumbers, meanValue;

    /**
     * @param jsonObject una representacion Json donde contiene un un atributo
     * defino como num, el cual es la lista de numeros del input
     * @return retorna un string que representa el valor del media y desviacion
     * estandar
     */
    public static int solve(int ans) {
        return ans * ans;
    }

    
}
