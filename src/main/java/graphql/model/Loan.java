package graphql.model;

/**
 * Created by Nicolas Chabanoles on 12/07/2018.
 */
public class Loan {

    private final String id;
    private final String customerId;
    private final String type;
    private final String status;

    public Loan(String customerId, String type, String status) {
        this(null, customerId, type, status);
    }

    public Loan(String id, String customerId, String type, String status) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.status = status;
    }

    public String getId() {return id;}
    public String getCustomer() {return customerId;}
    public String getType() {return type;}
    public String getStatus() {return status;}


}
