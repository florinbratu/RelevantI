package com.fbratu.relevant.gwt.server;

import com.fbratu.relevant.gwt.shared.ImmoLookupService;
import com.fbratu.relevant.ws.iface.ILookupService;
import com.fbratu.relevant.ws.iface.LookupException;
import com.fbratu.relevant.ws.iface.SearchCriteria;
import com.fbratu.relevant.ws.iface.SearchResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
@Service("immoLookup")
public class ImmoLookupServiceImpl extends RemoteServiceServlet implements
        ImmoLookupService {

    public List<com.fbratu.relevant.gwt.shared.SearchResult>
        searchOffers(String location) {
        WebApplicationContext ac = WebApplicationContextUtils
                .getWebApplicationContext(this.getServletContext());
        // reference to the WS client
        ILookupService webServiceRef = (ILookupService)ac.getBean("seLogerLookupService");
        try {
            SearchCriteria searchCriteria = new SearchCriteria();
            searchCriteria.setLocation(location);
            return  ServerToClientAdapter.serverToClient(
                    webServiceRef.searchOffers(searchCriteria));
        } catch (LookupException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SearchResult> searchOffersOld(String location) throws IllegalArgumentException {

        // test Error Handling
        if("emmerdeur".equals(location))
            throw new IllegalArgumentException("Thou shall not shit with me!");
        // test zero results
        if("himalaya".equals(location)) {
            return new ArrayList<SearchResult>();
        }
       // return hardcoded result
        // TODO call web service!!!
       List<SearchResult> ret = new ArrayList<SearchResult>();
        SearchResult result = new SearchResult(
                "Argenteuil 2 pieces",
                "ARGENTEUIL, val sud Appartement de type F2 au 3ème étage offrant entrée, séjour, cuisine...",
                "http://www.explorimmo.com/annonce-29235757-1.html?xtor=EPR-73"
        );
        ret.add(result);
        SearchResult result2 = new SearchResult(
                "Sartrouville 3 pieces",
                "Sartrouville, blahblahblah!...",
                "http://www.explorimmo.com/annonce-29235757-1.html?xtor=EPR-73"
        );
        ret.add(result2);
       return ret;

    }

}
