package graphql.model;

/**
 * Created by Nicolas Chabanoles on 12/07/2018.
 */
public class Loan {

    private final String id;
    private final String customer;
    private final String type;
    private final String status;

    public Loan(String customer, String type, String status) {
        this(null, customer, type, status);
    }

    public Loan(String id, String customer, String type, String status) {
        this.id = id;
        this.customer = customer;
        this.type = type;
        this.status = status;
    }

    public String getId() {return id;}
    public String getCustomer() {return customer;}
    public String getType() {return type;}
    public String getStatus() {return status;}


}
