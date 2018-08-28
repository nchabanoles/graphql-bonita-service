package graphql.model;

/**
 * Created by Nicolas Chabanoles on 12/07/2018.
 */
public class Customer {

    private final String id;
    private final String name;

    public Customer(String name) {
        this(null, name);
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {return id;}
    public String getName() {return name;}


}
