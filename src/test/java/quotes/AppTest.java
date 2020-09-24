/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class AppTest {
    @Test public void testRecentQuotesEmpty() {
        RecentQuotes quotesTest = new RecentQuotes("", "");
        assertEquals(" - ", quotesTest.toString());
    }

    @Test public void testRecentQuotesOne() throws IOException {
        Gson gson = new Gson();
        Reader quoteReader = Files.newBufferedReader(Paths.get("src/main/resources/recentQuotes.json"));
        RecentQuotes[] numQuotes = gson.fromJson(quoteReader, RecentQuotes[].class);
        String marilynQuote = "I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.";
        System.out.println(marilynQuote);
        RecentQuotes quotesTest = new RecentQuotes("Marilyn Monroe", marilynQuote);
        assertEquals("Marilyn Monroe - I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.", quotesTest.stringify(0, numQuotes));
    }

    @Test public void testRecentQuotesRandomNumber() {
        App quotesTest = new App();

        int min = 0;
        int max = 138;
        int random = quotesTest.getRandomNumber(min, max);
        assertTrue("Error, random is too high", 139 >= random);
    }
}
