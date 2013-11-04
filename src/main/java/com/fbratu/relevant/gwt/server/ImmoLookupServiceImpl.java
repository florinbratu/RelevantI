package com.fbratu.relevant.gwt.server;

import com.fbratu.relevant.gwt.shared.ImmoLookupService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.stereotype.Service;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
@Service("immoLookup")
public class ImmoLookupServiceImpl extends RemoteServiceServlet implements
        ImmoLookupService {

    public String searchOffers(String location) throws IllegalArgumentException {

        // test Error Handling
        if("emmerdeur".equals(location))
            throw new IllegalArgumentException("Thou shall not shit with me!");
       // right now, we will just return a Nothing found message
        // TODO right now Spring is only used to print its version. Not too useful huh?
       return "No results found in " + location
               + "\nRunning Spring version " + org.springframework.core.SpringVersion.getVersion();

    }

}
