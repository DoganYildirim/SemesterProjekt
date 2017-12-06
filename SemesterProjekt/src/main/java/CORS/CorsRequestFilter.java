/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CORS;

import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

/**
 *
 * @author marcofrydshou1
 */
public class CorsRequestFilter implements ContainerRequestFilter {
    
    private final static Logger log = Logger.getLogger(CorsRequestFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestCtx) throws IOException
    {
        // When HttpMethod comes as OPTIONS, just acknowledge that it accepts...
        if (requestCtx.getRequest().getMethod().equals("OPTIONS"))
        {
            log.info("HTTP Method (OPTIONS) - Detected!");
            // Just send a OK response back to the browser.
            // The response goes through the chain of applicable response filters.
            requestCtx.abortWith(Response.status(Response.Status.OK).build());
        }
    }
    
}
