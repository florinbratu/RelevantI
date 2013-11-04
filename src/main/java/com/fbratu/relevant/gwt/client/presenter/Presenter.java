package com.fbratu.relevant.gwt.client.presenter;

import com.fbratu.relevant.gwt.client.listener.ISearchListener;
import com.fbratu.relevant.gwt.client.listener.ISearchResultsListener;
import com.fbratu.relevant.gwt.client.view.ErrorView;
import com.fbratu.relevant.gwt.client.view.LoadingView;
import com.fbratu.relevant.gwt.client.view.states.ViewState;
import com.fbratu.relevant.gwt.client.view.results.SearchResultsPanel;
import com.fbratu.relevant.gwt.shared.dto.SearchResult;
import com.fbratu.relevant.gwt.shared.ImmoLookupService;
import com.fbratu.relevant.gwt.shared.ImmoLookupServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

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
 * Also: the presenter is the only entity interacting with the (mystic) Server side
 *
 * Author: Florin
 */
public class Presenter implements ISearchListener, ISearchResultsListener{

    // proxy to the remote service
    private final ImmoLookupServiceAsync lookupService;

    // the Loading screen
    private final LoadingView loadingWidget;

    // centralized error handling => ErrorView
    private final ErrorView errorView;

    // the view state aka what are we displaying
    private ViewState state;

    public Presenter(ViewState initialState) {
        state = initialState;
        state.activate();
        // init server side proxy
        lookupService = GWT.create(ImmoLookupService.class);
        // create the loading view
        loadingWidget = new LoadingView();
        // create the error handling object
        errorView = new ErrorView();
    }

    public ViewState getState() {
        return state;
    }

    public void setState(ViewState state) {
        this.state = state;
    }

    public void notifySearch(String searchLocation) {
        // get results for location
        // show loading widget
        loadingWidget.center();
        loadingWidget.show();
        lookupService.searchOffers(searchLocation, new AsyncCallback<List<SearchResult>>() {

            @Override
            public void onFailure(Throwable throwable) {
                loadingWidget.hide();
                errorView.show(throwable);
            }

            @Override
            public void onSuccess(List<SearchResult> results) {
                loadingWidget.hide();
                displaySearchResults(results);
            }
        });
    }

    private void displaySearchResults(List<SearchResult> results) {
        // TODO re-create SearchResults pannel
        // create brand-new state
        SearchResultsPanel resultsPanel = new SearchResultsPanel(results.get(0).toString());
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
