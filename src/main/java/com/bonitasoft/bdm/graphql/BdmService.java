package com.bonitasoft.bdm.graphql;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graphql.resolvers.Mutation;
import org.bonitasoft.engine.commons.TenantLifecycleService;
import org.bonitasoft.engine.commons.exceptions.SBonitaException;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import graphql.repositories.BookRepository;
import graphql.resolvers.Query;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

/**
 * Created by Nicolas Chabanoles on 12/07/18.
 */
@Component
@WebServlet(urlPatterns = "/graphql")
public class BdmService  extends SimpleGraphQLServlet implements TenantLifecycleService{

    private static final BookRepository bookRepository;
    static {
        MongoDatabase mongo = new MongoClient(new MongoClientURI("mongodb://mongouser:mongopassword@ds255319.mlab.com:55319/graphql-nodejs")).getDatabase("graphql-nodejs");
        bookRepository = new BookRepository(mongo.getCollection("books"));
    }

    public BdmService() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {

        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(bookRepository), new Mutation(bookRepository))
                .build()
                .makeExecutableSchema();
    }


    public String getServiceName() {
        return "BDM-Service-GraphQL-Plugin";
    }

    /**
     * Start the service
     *
     * @throws SBonitaException
     */
    @Override
    public void start() throws SBonitaException {
        System.out.println("Started " + getServiceName());
    }

    @Override
    public void stop() throws SBonitaException {
        System.out.println("stop " + getServiceName());
    }

    /**
     * Temporary halt the execution of this service.
     */
    @Override
    public void pause() throws SBonitaException {
        System.out.println("pause " + getServiceName());
    }

    /**
     * resume the execution the service
     */
    @Override
    public void resume() throws SBonitaException {
        System.out.println("resume " + getServiceName());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            super.doGet(request, response);
        } catch (ServletException e) {
            throw new IOException(e);
        }
        System.out.println("======================== COUCOU Logger =============================");
    }
}
