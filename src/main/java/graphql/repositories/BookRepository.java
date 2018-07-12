package graphql.repositories;


import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;

import graphql.model.Book;
import org.bson.Document;


/**
 * Created by Nicolas Chabanoles on 07/06/18.
 */
public class BookRepository {

    private final MongoCollection<Document> books;

    public BookRepository(MongoCollection<Document> books) {
        this.books = books;
    }

    public Book findById(String id) {
        Document doc = books.find(eq("_id", new ObjectId(id))).first();
        return toBook(doc);
    }

    private Book toBook(Document doc) {
        return new Book(
                doc.get("_id").toString(),
                doc.getString("name"),
                doc.getString("genre"));
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        books.find().forEach((Consumer<? super Document>) document -> {
            allBooks.add(toBook(document));
        });
        return allBooks;
    }

    public Book saveBook(Book book) {
        Document doc = new Document();
        doc.append("name", book.getName());
        doc.append("genre", book.getGenre());
        books.insertOne(doc);
        return toBook(doc);
    }
}