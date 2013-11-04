package com.fbratu.relevant.gwt.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side interface for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/immoLookup")
public interface ImmoLookupService extends RemoteService {
  String searchOffers(String location) throws IllegalArgumentException;
}
