package com.fbratu.relevant.gwt.client.view.search;

import com.fbratu.relevant.gwt.client.Resources;
import com.fbratu.relevant.gwt.client.listener.ISearchListener;
import com.fbratu.relevant.gwt.client.view.states.ViewState;
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
public class SearchPanel extends Composite implements ViewState {

    @UiTemplate("SearchPanel.ui.xml")
    interface SearchPanelUiBinder extends UiBinder<Widget, SearchPanel> {
    }
    private static SearchPanelUiBinder uiBinder = GWT.create(SearchPanelUiBinder.class);

    @UiField
    Button searchButton;

    // UI component storing the search location field
    @UiField
    TextBox searchLocationField;

    @UiField
    Label errorLabel;

    @UiField
    Resources res;

    private static final String SEARCH_LOCATION_HINT = "Location";

    // single listener is enough for us
    private ISearchListener searchListener;

    public SearchPanel()  {
    }

    public void create() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("searchButton")
    public void handleClick(ClickEvent clickEvent) {
        triggerSearch();
    }

    private void createSearchLocationField() {
        final TextBox locationField = new TextBox();
        locationField.setText(SEARCH_LOCATION_HINT);
        locationField.addStyleName("searchLocationHint");
        // blur handler -> set default hint
        locationField.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent blurEvent) {
                String currentValue = locationField.getText();
                if("".equals(currentValue)) {
                   locationField.setText(SEARCH_LOCATION_HINT);
                   // greyed style
                   locationField.removeStyleName("searchLocationFocused");
                   locationField.addStyleName("searchLocationHint");
                }
            }
        });
        // focus handler: if hint mode => switch  to focused mode
        locationField.addFocusHandler(new FocusHandler() {
            @Override
            public void onFocus(FocusEvent focusEvent) {
                String currentValue = locationField.getText();
                if(SEARCH_LOCATION_HINT.equals(currentValue)) {
                    locationField.setValue("");
                    // focused style
                    locationField.addStyleName("searchLocationFocused");
                    locationField.removeStyleName("searchLocationHint");
                }
            }
        });
        RootPanel.get("searchLocationFieldContainer").add(locationField);
        // need to access it when triggering search
        searchLocationField = locationField;
        // handler to trigger search on ENTER
        locationField.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent keyUpEvent) {
                if (keyUpEvent.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    triggerSearch();
                }
            }
        });
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

    @Override
    public void invalidate() {
        searchButton.setEnabled(false);
        searchLocationField.setEnabled(false);
    }

    @Override
    public void activate() {
        searchButton.setEnabled(true);
        searchLocationField.setEnabled(true);
        searchLocationField.setFocus(true);
    }

    public void registerSearchListener(ISearchListener searchListener) {
        this.searchListener = searchListener;
    }
}
