package com.fbratu.relevant.gwt.client.presenter;

import com.fbratu.relevant.gwt.client.listener.ISearchListener;
import com.fbratu.relevant.gwt.client.listener.ISearchResultsListener;
import com.fbratu.relevant.gwt.client.view.states.ViewState;
import com.fbratu.relevant.gwt.client.view.results.SearchResultsPanel;

/**
 * The Presenter, as per the MVP pattern.
 * It is implemented as State pattern.
 * For each events coming from the View,
 * the view state switches accordingly, and if need be
 * some processing is performed
 *
 * The view state may switch to a new view, or to an already-existing one
 * In the latter case, resources are recycled(especially when switching back to
 * already-seen views)
 *
 * Author: Florin
 */
public class Presenter implements ISearchListener, ISearchResultsListener{

    private ViewState state;

    public Presenter(ViewState initialState) {
        state = initialState;
        state.activate();
    }

    public ViewState getState() {
        return state;
    }

    public void setState(ViewState state) {
        this.state = state;
    }

    public void notifySearch(String searchLocation) {
        // get results for location
        // TODO call remote service!
        String searchResults = searchLocation;
        // create brand-new state
        SearchResultsPanel resultsPanel = new SearchResultsPanel(searchResults);
        resultsPanel.create();
        resultsPanel.registerListener(this);
        // state switch: Search -> Search results
        // disable old state
        state.invalidate();
        // set new state
        resultsPanel.setSearchPanel(state);
        state = resultsPanel;
        state.activate();
    }

    @Override
    public void notifySearchResultsClosed(ViewState searchPage) {
        // state switch: Search Results -> Search page
        state.invalidate();
        state = searchPage;
        state.activate();
    }
}
