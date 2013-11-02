package com.fbratu.relevant.gwt.server;

import com.fbratu.relevant.gwt.shared.ImmoLookupService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ImmoLookupServiceImpl extends RemoteServiceServlet implements
        ImmoLookupService {

    public String searchOffers(String location) throws IllegalArgumentException {

       // TODO actually do some useful stuff here; like call a Spring service?
       // right now, we will just return a Nothing found message
       return "No results found in " + location;

    }

}
