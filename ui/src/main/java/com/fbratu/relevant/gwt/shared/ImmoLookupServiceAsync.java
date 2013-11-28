package com.fbratu.relevant.gwt.shared;

import com.fbratu.relevant.ws.iface.SearchResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * The async counterpart of <code>ImmoLookupService</code>.
 */
public interface ImmoLookupServiceAsync {
  void searchOffers(String location, AsyncCallback<List<SearchResult>> callback)
      throws IllegalArgumentException;
}
