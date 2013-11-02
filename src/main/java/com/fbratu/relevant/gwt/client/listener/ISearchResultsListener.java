package com.fbratu.relevant.gwt.client.listener;

import com.fbratu.relevant.gwt.client.view.states.ViewState;

/**
 * Interface for listener to events triggered from the Search Results page
 *
 * Author: Florin
 */
public interface ISearchResultsListener {
    /*
    * Triggered when user clicks the Close
    * button on the Search Results view page
    *
    * @param searchPage the previous search page generating these Results
    */
    void notifySearchResultsClosed(ViewState searchPage);
}
