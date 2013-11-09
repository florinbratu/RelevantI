package com.fbratu.relevant.gwt.client.view.results;

import com.fbratu.relevant.gwt.client.Resources;
import com.fbratu.relevant.gwt.client.listener.ISearchResultsListener;
import com.fbratu.relevant.gwt.client.view.main.State;
import com.fbratu.relevant.gwt.shared.dto.SearchResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

import java.util.List;

/**
 * Author: Florin
 */
public class SearchResultsPanel extends Composite {

    interface SearchResultsUiBinder extends UiBinder<Widget, SearchResultsPanel> {}

    private SearchResultsUiBinder uiBinder;

    @UiField
    SpanElement searchCriteria;

    @UiField
    VerticalPanel resultsPanel;

    @UiField
    Button backButton;

    // the Listener
    private ISearchResultsListener searchResultsListener;

    public SearchResultsPanel() {
        uiBinder = GWT.create(SearchResultsUiBinder.class);
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void registerListener(ISearchResultsListener listener) {
        searchResultsListener = listener;
    }

    @UiHandler("backButton")
    public void onBack(ClickEvent event) {
        resultsPanel.clear();
        // state switch: Search Results -> Search page
        searchResultsListener.notifySearchResultsClosed();
    }

    public void setSearchCriteria(String searchLocation) {
        searchCriteria.setInnerText(searchLocation);
    }

    public void setResults(List<SearchResult> results) {
        for(SearchResult result : results) {
            SearchResultWidget resultWidget = new SearchResultWidget();
            resultWidget.setResult(result);
            resultsPanel.add(resultWidget);
        }
    }
}
