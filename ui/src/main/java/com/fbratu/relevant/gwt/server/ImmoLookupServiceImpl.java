package com.fbratu.relevant.gwt.server;

import com.fbratu.relevant.gwt.shared.ImmoLookupService;
import com.fbratu.relevant.ws.iface.ILookupService;
import com.fbratu.relevant.ws.iface.LookupException;
import com.fbratu.relevant.ws.iface.SearchCriteria;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
@Service("immoLookup")
public class ImmoLookupServiceImpl extends RemoteServiceServlet implements
        ImmoLookupService {

    @Autowired
    @Qualifier("seLogerLookupService")
    private ILookupService webServiceRef;

    public List<com.fbratu.relevant.gwt.shared.SearchResult>
    searchOffers(String location) {
        try {
            SearchCriteria searchCriteria = new SearchCriteria();
            searchCriteria.setLocation(location);
            return  ServerToClientAdapter.serverToClient(
                    webServiceRef.searchOffers(searchCriteria));
        } catch (LookupException e) {
            throw new RuntimeException(e);
        }
    }

}
