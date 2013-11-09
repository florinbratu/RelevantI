package com.fbratu.relevant.gwt.client.view.main;

import com.fbratu.relevant.gwt.client.presenter.Presenter;
import com.fbratu.relevant.gwt.client.view.results.SearchResultsPanel;
import com.fbratu.relevant.gwt.client.view.search.SearchPanel;
import com.fbratu.relevant.gwt.shared.dto.SearchResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.LazyPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.List;

/**
 * Multi-page GWT application, implemented as a Deck Panel
 * containing the rest of application-specific panels corresponding
 * to various view states(Search page, Search results, etc..)
 *
 * Implements lazy components loading: at each moment only active
 * view is loaded. At each state transition the current view is
 * disabled and the next state is activated
 *
 * Implements Histroical navigation support
 *
 * Author: Florin
 */
public class MainPanel extends Composite implements ValueChangeHandler<String> {

    interface MainPanelUiBinder extends UiBinder<Widget, MainPanel>
    {
    }
    private MainPanelUiBinder uiBinder;

    @UiField
    DeckPanel mainPanel;

    // lazy equivalents required
    // see https://groups.google.com/forum/#!msg/google-web-toolkit/oVx2rHk4eF8/0_Av9-VQn8sJ
    @UiField
    LazyPanel lazySearchPanel;

    @UiField
    SearchPanel searchPanel;

    private static final int SEARCH_PANEL_WIDGET_ID = 0;

    @UiField
    SearchResultsPanel searchResultsPanel;

    @UiField
    LazyPanel lazySearchResultsPanel;

    private static final int SEARCH_RESULTS_PANEL_WIDGET_ID = 1;

    private Presenter presenter;

    public MainPanel() {
        uiBinder = GWT.create(MainPanelUiBinder.class);
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void showInitialPanel() {
        // initial panel is Search
        showSearchPanel();
    }

    public void showSearchResultsPanel(String searchLocation, List<SearchResult> results) {
        // show
        mainPanel.showWidget(SEARCH_RESULTS_PANEL_WIDGET_ID);
        // set search criteria, for redisplay
        searchResultsPanel.setSearchCriteria(searchLocation);
        // set results
        searchResultsPanel.setResults(results);
        // register listener
        searchResultsPanel.registerListener(presenter);
        // register historical landmark
        History.newItem(State.SEARCH_RESULTS.toString(), false);
    }

    public void showSearchPanel() {
        // show
        mainPanel.showWidget(SEARCH_PANEL_WIDGET_ID);
        // register listener
        searchPanel.registerSearchListener(presenter);
        // historical landmark. but don't trigger event!
        History.newItem(State.SEARCH_PAGE.toString(), false);
    }

    public void registerAsListener(Presenter presenter) {
         // since it's lazy; we register it when components are shown
        // so just store it for now
        this.presenter = presenter;
    }

    /**
     * history
     */
    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String oldStateName = event.getValue();
        State oldState = State.getByName(oldStateName);
        switch (oldState) {
            case SEARCH_PAGE:
                showSearchPanel();
                break;
            case SEARCH_RESULTS:
                showSearchResultsPanel("TODO",new ArrayList<SearchResult>());
                break;
        }
    }
}
