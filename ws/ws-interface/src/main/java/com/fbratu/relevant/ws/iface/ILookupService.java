package com.fbratu.relevant.ws.iface;

import javax.jws.WebService;
import java.util.List;

/**
 * Author: Florin
 */
@WebService(name = "LookupServicePortType")
public interface ILookupService {
    List<SearchResult> searchOffers(SearchCriteria criteria) throws LookupException;
}
