package graphql.model;

/**
 * Created by Nicolas Chabanoles on 07/06/18.
 */
public class Book {
    private final String id;
    private final String name;
    private final String genre;

    public Book(String name, String genre) {
        this(null, name, genre);
    }

    public Book(String id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public String getId() {return id;}
    public String getName() {return name;}
    public String getGenre() {return genre;}


}
