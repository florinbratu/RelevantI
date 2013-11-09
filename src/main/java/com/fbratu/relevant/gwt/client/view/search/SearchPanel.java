package com.fbratu.relevant.gwt.client.view.search;

import com.fbratu.relevant.gwt.client.Resources;
import com.fbratu.relevant.gwt.client.listener.ISearchListener;
import com.fbratu.relevant.gwt.client.FieldVerifier;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;

/**
 * author: Florin
 */
public class SearchPanel extends Composite {

    @UiTemplate("SearchPanel.ui.xml")
    interface SearchPanelUiBinder extends UiBinder<Widget, SearchPanel> {
    }
    private SearchPanelUiBinder uiBinder;

    @UiField
    Button searchButton;

    // UI component storing the search location field
    @UiField
    TextBox searchLocationField;

    @UiField
    Label errorLabel;

    @UiField(provided = true)
    Resources res;

    private static final String SEARCH_LOCATION_HINT = "Location";

    // single listener is enough for us
    private ISearchListener searchListener;

    public SearchPanel()  {
        uiBinder = GWT.create(SearchPanelUiBinder.class);
        res = GWT.create(Resources.class);
        initWidget(uiBinder.createAndBindUi(this));
        res.searchStyle().ensureInjected();
    }

    @UiHandler("searchButton")
    public void handleClick(ClickEvent clickEvent) {
        triggerSearch();
    }

    @UiHandler("searchLocationField")
    public void onFocus(FocusEvent focusEvent) {
        String currentValue = searchLocationField.getText();
        if(SEARCH_LOCATION_HINT.equals(currentValue)) {
            searchLocationField.setValue("");
            // focused style
            searchLocationField.addStyleName(res.searchStyle().searchLocationFocused());
            searchLocationField.removeStyleName(res.searchStyle().searchLocationHint());
        }
    }

    @UiHandler("searchLocationField")
    public void onBlur(BlurEvent blurEvent) {
        String currentValue = searchLocationField.getText();
        if("".equals(currentValue)) {
            searchLocationField.setText(SEARCH_LOCATION_HINT);
            // greyed style
            searchLocationField.removeStyleName(res.searchStyle().searchLocationFocused());
            searchLocationField.addStyleName(res.searchStyle().searchLocationHint());
        }
    }

    @UiHandler("searchLocationField")
    public void onKeyUp(KeyUpEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            triggerSearch();
        }
    }

    private void triggerSearch() {
        // input validation
        errorLabel.setText("");
        String location = searchLocationField.getText();
        if (!FieldVerifier.isValidName(location)) {
            errorLabel.setText("Please enter a valid location");
            return;
        }
        searchListener.notifySearch(location);
    }

    public void registerSearchListener(ISearchListener searchListener) {
        this.searchListener = searchListener;
    }
}
