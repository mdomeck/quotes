package quotes;

public class StarWarsQuote extends RecentQuote {

    String starWarsQuote;

    public StarWarsQuote(String author, String text, String starWarsQuote) {
        super(author, text);
        this.starWarsQuote = starWarsQuote;


    }

    public void normalizeQuote(){
        this.text = this.starWarsQuote;
        this.author = "starwars";


       // this.text = this.starWarsQuote.split("\\s'\u2014'\\s")[0].toString();
       // this.author = this.starWarsQuote.split("\\s'\u2014'\\s")[1].toString();
    }

    public String toString(){
        return String.format("Quote: %s ", starWarsQuote);

    }
}
