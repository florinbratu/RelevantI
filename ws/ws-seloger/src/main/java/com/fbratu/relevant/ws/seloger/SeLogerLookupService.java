package com.fbratu.relevant.ws.seloger;

import com.fbratu.relevant.ws.iface.ILookupService;
import com.fbratu.relevant.ws.iface.LookupException;
import com.fbratu.relevant.ws.iface.SearchCriteria;
import com.fbratu.relevant.ws.iface.SearchResult;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Florin
 */
@WebService(serviceName = "SeLogerLookupService",
        endpointInterface = "com.fbratu.relevant.ws.iface.ILookupService",
        portName = "SeLogerLookupPort" )
public class SeLogerLookupService implements ILookupService{

    @Override
    public List<SearchResult> searchOffers(SearchCriteria criteria) throws LookupException {
        // right now is isofunctional with ImmoLookupServiceImpl
        // TODO actually crawl seloger!
        // test Error Handling
        if("emmerdeur".equals(criteria.getLocation()))
            throw new LookupException("Thou shall not shit with me!");
        // test zero results
        if("himalaya".equals(criteria.getLocation())) {
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
