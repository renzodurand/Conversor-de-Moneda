package main;

import models.ApiConnection;
import models.Conversor;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String apiKey = "f4de335d568beee28d8f4751";

        String baseCoin = "";
        String targetCoin = "";
        String amount = "";
        int start = 1;


        while (start == 1) {
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println( "****************************************\n" +
                        "Hola, bienvenido al Conversor de Monedas: \n" +
                        "1) Dolar           >>>  Peso Argentino\n" +
                        "2) Peso Argentino  >>>  Dolar\n" +
                        "3) Dolar           >>>  Real Brasileño\n" +
                        "4) Real Brasileño  >>>  Dolar\n" +
                        "5) Dolar           >>>  Peso Colombiano\n" +
                        "6) Peso Colombiano >>>  Dolar\n" +
                        "7) Salir\n" +
                        "Elija una número válido:");

                int option = sc.nextInt();
                sc.nextLine();

                while(option < 1 || option > 7){
                    System.out.println("Opción no válida, por favor ingrese una opción válida: ");
                    option = sc.nextInt();
                    sc.nextLine();
                }

                switch (option){
                    case 1:
                        baseCoin = "USD";
                        targetCoin = "ARS";
                        System.out.println("Ingrese el monto a convertir: ");
                        amount = sc.nextLine();
                        break;
                    case 2:
                        baseCoin = "ARS";
                        targetCoin = "USD";
                        System.out.println("Ingrese el monto a convertir: ");
                        amount = sc.nextLine();
                        break;
                    case 3:
                        baseCoin = "USD";
                        targetCoin = "BRL";
                        System.out.println("Ingrese el monto a convertir: ");
                        amount = sc.nextLine();
                        break;
                    case 4:
                        baseCoin = "BRL";
                        targetCoin = "USD";
                        System.out.println("Ingrese el monto a convertir: ");
                        amount = sc.nextLine();
                        break;
                    case 5:
                        baseCoin = "USD";
                        targetCoin = "COP";
                        System.out.println("Ingrese el monto a convertir: ");
                        amount = sc.nextLine();
                        break;
                    case 6:
                        baseCoin = "COP";
                        targetCoin = "USD";
                        System.out.println("Ingrese el monto a convertir: ");
                        amount = sc.nextLine();
                        break;
                    case 7:
                        System.out.println("Muchas gracias por visitarnos!");
                        start = 7;
                        break;
                }

                if (start == 7){
                    System.out.println("Finalizando Programa...");
                    break;
                }

                String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCoin + "/" + targetCoin + "/" + amount;
                ApiConnection apiConnection = new ApiConnection(url);
                Conversor conversor = new Conversor(apiConnection.getResponseBody());

                System.out.println("RESULTADO");
                System.out.println("************************************");
                System.out.println( "Moneda Base     : " + conversor.getBaseCoin() + "\n" +
                                    "Moneda Objetivo : " + conversor.getTargetCoin() + "\n" +
                                    "Monto Ingresado : " + amount + "\n" +
                                    "Tasa de Cambio  : " + conversor.getConversionRate() + "\n" +
                                    "Monto Convertido: " + conversor.getConversionResult());
                System.out.println("************************************");

                System.out.println( "Desea volver al menú principal? Escriba el número de opción correcto:\n" +
                                    "1) Si\n" +
                                    "2) No");
                int continuar = sc.nextInt();
                try{
                    if(continuar == 1){
                        for (int j=3; j!=0; j--){
                            System.out.println("Regresando al menú principal en "+ j);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException o) {
                                o.printStackTrace();
                            }
                        }
                    }if(continuar == 2) {
                        break;
                    }
                }catch(RuntimeException e){
                    //It's working with the other catch thanks for the scope I think.
                }


            }catch(RuntimeException e){
                System.out.println("************************************");
                System.out.println(">>>> ERROR: CARÁCTER INVÁLIDO!!!!!!!");
                for(int i = 10; i!=0; i--){
                    System.out.println(">>>> Autodestrucción en: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException o) {
                        o.printStackTrace();
                    }
                }
                System.out.println("Bromita, yo no te haré daño c: ");
                break;
            }
        }

    }
}