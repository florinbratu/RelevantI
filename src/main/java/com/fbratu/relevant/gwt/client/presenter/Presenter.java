package com.fbratu.relevant.gwt.client.presenter;

import com.fbratu.relevant.gwt.client.listener.ISearchListener;
import com.fbratu.relevant.gwt.client.view.search.SearchPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * The Presenter, as per the MVP pattern.
 * TODO implement as State pattern
 *
 * Author: Florin
 */
public class Presenter implements ISearchListener{

    private final SearchPanel searchPanel;

    // for the time being: search results in a crappy Popup
    private final PopupPanel searchResultsPanel;

    private final Label resultsLabel;

    public Presenter(SearchPanel searchPanel) {
        this.searchPanel = searchPanel;
        this.searchPanel.registerSearchListener(this);
        this.searchResultsPanel = new PopupPanel(true);
        this.resultsLabel = new Label();
        searchResultsPanel.setWidget(resultsLabel);
        searchResultsPanel.center();
    }

    public void notifySearch(String searchLocation) {
        // lame version. In the future at least call remote service!
        resultsLabel.setText(searchLocation);
        searchResultsPanel.show();
    }
}
