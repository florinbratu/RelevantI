package com.fbratu.relevant.gwt.client.view.results;

import com.fbratu.relevant.gwt.client.Resources;
import com.fbratu.relevant.gwt.client.listener.ISearchResultsListener;
import com.fbratu.relevant.gwt.shared.dto.SearchResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

import java.util.List;

/**
 * Author: Florin
 */
public class SearchResultsPanel extends Composite {

    @UiTemplate("SearchResultWidget.ui.xml")
    interface SearchResultsUiBinder extends UiBinder<Widget, SearchResultsPanel>{}

    private SearchResultsUiBinder uiBinder;

    @UiField
    Anchor resultTitle;

    @UiField
    Label resultDescription;

    // the Listener
    private ISearchResultsListener searchResultsListener;

    // URL container
    private final StringBuilder urlPlaceholder;

    public SearchResultsPanel() {
        uiBinder = GWT.create(SearchResultsUiBinder.class);
        initWidget(uiBinder.createAndBindUi(this));
        urlPlaceholder = new StringBuilder();
    }

    @UiHandler("resultTitle")
    public void onClick(ClickEvent clickEvent) {
        Window.Location.replace(urlPlaceholder.toString());
    }

    public void registerListener(ISearchResultsListener listener) {
        searchResultsListener = listener;
    }

    public void setResults(List<SearchResult> results) {
        SearchResult result = results.get(0);
        resultTitle.setText(result.getTitle());
        resultDescription.setText(result.getDescription());
        urlPlaceholder.setLength(0);
        urlPlaceholder.append(result.getOriginalAnnounceLink());
    }
}
