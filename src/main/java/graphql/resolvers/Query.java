package graphql.resolvers;

import java.util.ArrayList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import graphql.model.Book;
import graphql.model.Customer;
import graphql.model.Loan;
import graphql.repositories.BookRepository;

/**
 * Created by Nicolas Chabanoles on 07/06/18.
 */
public class Query implements GraphQLRootResolver {

    private final BookRepository bookRepository;

    private static List<Customer> result;
    static {
        result = new ArrayList<>();
        result.add(new Customer("7", "Nicolas"));
        result.add(new Customer("999", "Danila"));
    }

    public Query(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.getAllBooks();
    }

    public Book book(String id) { return bookRepository.findById(id); }

    public List<Loan> allLoans() {
        List<Loan> allLoans = new ArrayList<>();
        allLoans.add(new Loan("Nicolas","House","Missing Documents"));
        System.out.println("Returning loans!");
        return allLoans;
    }

    public List<Customer> allCustomers() {

        System.out.println("Returning loans!");
        return result;
    }

    public Customer customer(String id) {
        if ("7".equals(id)) {
            return result.get(0);
        }
        if("999".equals(id)) {
            return result.get(1);
        }
        return null;
    }
}