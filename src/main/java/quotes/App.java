/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;


import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;


public class App {


    public static void main(String[] args) throws IOException {

        returnQuote();


    }

    public static void returnQuote() throws IOException {


        int responseCode = -1;
        HttpURLConnection connection;

        try {
            URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            responseCode = connection.getResponseCode();


            if (responseCode != 200) {

                try {
                    Gson gson = new Gson();
                    RecentQuote quotes = new RecentQuote("Charles Dickens", "Hello?");
                    System.out.println(quotes);
                    Reader quoteReader = Files.newBufferedReader(Paths.get("src/main/resources/recentQuotes.json"));
                    RecentQuote[] numQuotes = gson.fromJson(quoteReader, RecentQuote[].class);
                    System.out.println(quotes.stringify(getRandomNumber(0, 138), numQuotes));

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String oneLine = input.readLine();
                StringBuffer entireStringFromResponse = new StringBuffer();

                while (oneLine != null) {
                    entireStringFromResponse.append(oneLine);
                   oneLine = input.readLine();
                }
                input.close();

                System.out.println(entireStringFromResponse);
                String testing = String.valueOf(entireStringFromResponse);

                Gson g = new Gson();
                StarWarsQuote q = g.fromJson(testing, StarWarsQuote.class);
                q.normalizeQuote();

                Reader quoteReader = Files.newBufferedReader(Paths.get("src/main/resources/recentQuotes.json"));
                RecentQuote[] numQuotes = g.fromJson(quoteReader, RecentQuote[].class);
                ArrayList<RecentQuote> array = new ArrayList<>(Arrays.asList(numQuotes));
                array.add(q);

               // System.out.println(q);

                FileWriter infoFileWriter = new FileWriter("src/main/resources/recentQuotes.json");
                g.toJson(array, infoFileWriter);
                infoFileWriter.close();


            }
        } catch (Exception ex) {
        System.out.println(ex);
        }
    }


    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}

