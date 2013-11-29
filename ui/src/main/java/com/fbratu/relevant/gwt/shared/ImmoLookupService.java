package com.fbratu.relevant.gwt.shared;

import com.fbratu.relevant.gwt.shared.SearchResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * The client side interface for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/immoLookup")
public interface ImmoLookupService extends RemoteService {
  List<SearchResult> searchOffers(String location) throws IllegalArgumentException;
}
