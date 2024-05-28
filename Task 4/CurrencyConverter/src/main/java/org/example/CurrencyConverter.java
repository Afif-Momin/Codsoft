package org.example;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Currency Converter:");
        System.out.println("------------------");

        System.out.println("Enter a base currency (example: INR,USD,EUR):");
        String Basecurrency = scan.next().toUpperCase();

        System.out.println("Enter a target currency (example: INR,USD,EUR):");
        String Targetcurrency = scan.next().toUpperCase();

        //double ExchangeRate = getExchangeRate(Basecurrency,Targetcurrency);

        System.out.println("Enter a amount in "+ Basecurrency);
        BigDecimal Basevalue = scan.nextBigDecimal();

       // String URL = "https://api.freecurrencyapi.com/"+ Targetcurrency.toUpperCase()+ "&base_currency="+Basecurrency.toUpperCase();
        // For Security Reasons, I have removed my API key for reference I have used api from freecurrencyapi

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL)
                .get()
                .build();

        Response response = client.newCall(request).execute();

        String result = response.body().string();
        JSONObject object = new JSONObject(result);
        JSONObject rateobj = object.getJSONObject("data");
        BigDecimal rate = rateobj.getBigDecimal(Targetcurrency.toUpperCase());

        BigDecimal answer = rate.multiply(Basevalue);
        System.out.println(Basecurrency +" : "+ Basevalue +" is "+ Targetcurrency +" : "+ answer);


    }
}
