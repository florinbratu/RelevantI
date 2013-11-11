package com.fbratu.relevant.gwt.client.view.results;

import com.fbratu.relevant.gwt.shared.dto.SearchResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

/**
 * Widget displaying a single SearchResult
 * Author: Florin
 */
public class SearchResultWidget extends Composite{
    @UiTemplate("SearchResultWidget.ui.xml")
    interface SearchResultUiBinder extends UiBinder<Widget, SearchResultWidget> {}

    private static final SearchResultUiBinder uiBinder = GWT.create(SearchResultUiBinder.class);

    @UiField
    Anchor resultTitle;

    @UiField
    Label resultDescription;

    // URL container
    private final StringBuilder urlPlaceholder;

    public SearchResultWidget() {
        initWidget(uiBinder.createAndBindUi(this));
        urlPlaceholder = new StringBuilder();
    }

    @UiHandler("resultTitle")
    public void onClick(ClickEvent clickEvent) {
        Window.Location.assign(urlPlaceholder.toString());
    }

    public void setResult(SearchResult result) {
        resultTitle.setText(result.getTitle());
        resultDescription.setText(result.getDescription());
        urlPlaceholder.setLength(0);
        urlPlaceholder.append(result.getOriginalAnnounceLink());
    }
}
