package quotes;

public class StarWarsQuote extends RecentQuote {

    String starWarsQuote;

    public StarWarsQuote(String text, String author) {
        super(text, author);



    }

    public void normalizeQuote(){
        this.text = this.starWarsQuote.split("\\s-\\s")[0].toString();
        this.author = this.starWarsQuote.split("\\s-\\s")[1].toString();
    }

//    public String toString(){
//        return String.format("Quote: %s ", starWarsQuote);
//
//    }
}
