package quotes;

public class StarsWarsQuote extends RecentQuotes{
    int id;
    int faction;
    String starWarsQuote;

    public StarsWarsQuote(String author, String text, String starWarsQuote) {
        super(author, text);
        this.starWarsQuote = starWarsQuote;

    }

    public String toString(){
        return String.format("Quote: %s ", starWarsQuote);

    }
}
