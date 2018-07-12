package graphql.resolvers;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import graphql.model.Book;
import graphql.repositories.BookRepository;

/**
 * Created by Nicolas Chabanoles on 07/06/18.
 */
public class Query implements GraphQLRootResolver {

    private final BookRepository bookRepository;

    public Query(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.getAllBooks();
    }

    public Book book(String id) { return bookRepository.findById(id); }

}