package com.fbratu.relevant.gwt.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>ImmoLookupService</code>.
 */
public interface ImmoLookupServiceAsync {
  void searchOffers(String location, AsyncCallback<String> callback)
      throws IllegalArgumentException;
}
