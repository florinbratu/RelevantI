package com.fbratu.relevant.gwt.client.listener;

/**
 * Interface defining listener for a Search launch, via the Search Panel.
 *
 * Author: Florin
 */
public interface ISearchListener {
    /*
    * Triggered when user clicks the Search button
    * to look for real estate announcements
    */
    public void notifySearch(String searchLocation);
}
