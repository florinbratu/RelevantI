package com.fbratu.relevant.gwt.client.view.results;

import com.fbratu.relevant.gwt.client.listener.ISearchResultsListener;
import com.fbratu.relevant.gwt.client.view.states.ViewState;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Author: Florin
 */
public class SearchResultsPanel implements ViewState{

    // lame: result is a String. shit.
    private final String searchResult;

    // the results are displayed in a popup
    private DialogBox popup;

    private Button closeButton;

    // the previous view showing this
    private ViewState previousView;

    // the Listener
    private ISearchResultsListener searchResultsListener;

    public SearchResultsPanel(String result) {
        searchResult = result;
    }

    public void setSearchPanel(ViewState previousView) {
        this.previousView = previousView;
    }

    public void registerListener(ISearchResultsListener listener) {
        searchResultsListener = listener;
    }

    public void create() {
        // Create a popup dialog box
        popup = new DialogBox();
        popup.setText("Search results:");
        popup.setAnimationEnabled(true);
        closeButton = new Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Here are the offers:</b>"));
        dialogVPanel.add(new Label(searchResult));
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        popup.setWidget(dialogVPanel);

        // Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                searchResultsListener.notifySearchResultsClosed(previousView);
            }
        });
    }

    @Override
    public void activate() {
        popup.center();
        closeButton.setFocus(true);
        popup.show();
    }

    @Override
    public void invalidate() {
        popup.hide();
    }
}
