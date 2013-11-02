package com.fbratu.relevant.gwt.client.view.states;

/**
 * One possible state of the View. But not domain-wise - nothing to do with data,
 * think more State pattern.
 *
 * Author: Florin
 */
public interface ViewState {
    void activate();
    void invalidate();
}
