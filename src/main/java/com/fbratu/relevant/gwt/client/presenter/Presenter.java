package com.fbratu.relevant.gwt.client.presenter;

import com.fbratu.relevant.gwt.client.listener.ISearchListener;
import com.fbratu.relevant.gwt.client.listener.ISearchResultsListener;
import com.fbratu.relevant.gwt.client.view.ErrorView;
import com.fbratu.relevant.gwt.client.view.LoadingView;
import com.fbratu.relevant.gwt.client.view.main.MainPanel;
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
 * The State is actually stored and handled by the Main Panel
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

    // the Main Panel
    private final MainPanel mainPanel;

    public Presenter(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        // init server side proxy
        lookupService = GWT.create(ImmoLookupService.class);
        // create the loading view
        loadingWidget = new LoadingView();
        // create the error handling object
        errorView = new ErrorView();
    }

    public void start() {
        // display initial panel
        mainPanel.showInitialPanel();
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
        mainPanel.showSearchResultsPanel(results);
    }

    @Override
    public void notifySearchResultsClosed() {
        // state switch: Search Results -> Search page
        mainPanel.showSearchPanel();
    }
}
