package com.bonitasoft.bdm.graphql;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bonitasoft.engine.commons.TenantLifecycleService;
import org.bonitasoft.engine.commons.exceptions.SBonitaException;
import org.springframework.stereotype.Component;

/**
 * Created by Nicolas Chabanoles on 12/07/18.
 */
@Component
@WebServlet(urlPatterns = "/graphql")
public class BdmService  extends HttpServlet implements TenantLifecycleService{

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
        response.getWriter().println("======================== COUCOU writer =============================");
        System.out.println("======================== COUCOU Logger =============================");
    }
}
