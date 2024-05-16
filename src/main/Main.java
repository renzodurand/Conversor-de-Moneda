package main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.ApiConnection;
import models.Conversor;
import models.ConversorRecord;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, write the number of the option: \n" +
                            "1) Currency Exchange\n" +
                            "2) Exit");
        int respuesta = sc.nextInt();
        sc.nextLine();

        while (respuesta == 1) {

            System.out.println("Please, write de currency you have: (Example:'USD')");
            String baseCoin = sc.nextLine();
            System.out.println("Please, write the currency you want to convert to: (Example:'CAD')");
            String targetCoin = sc.nextLine();
            System.out.println("Finally, write the amount of money you want to convert:");
            String amount = sc.nextLine();

            String apiKey = "f4de335d568beee28d8f4751";
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCoin + "/" + targetCoin + "/" + amount;

            ApiConnection apiConnection = new ApiConnection(url);
            Conversor conversor = new Conversor(apiConnection.getResponseBody());


            System.out.println("************************************");
            System.out.println("Base: " + conversor.getBaseCoin() + "\n" +
                    "Target : " + conversor.getTargetCoin() + "\n" +
                    "Amount : " + amount + "\n" +
                    "Rate   : " + conversor.getConversionRate() + "\n" +
                    "Results: " + conversor.getConversionResult());
            System.out.println("************************************\n");

            System.out.println("Hello, write the number of the option: \n" +
                    "1 Currency Exchange\n" +
                    "2 Exit");
            respuesta = sc.nextInt();
            sc.nextLine();
        }
        if(respuesta == 2) {
            System.out.println("Thanks for using ExchangeRate");
        }
        else {
            System.out.println("Incorrect Option");
        }


    }
}