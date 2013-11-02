package com.fbratu.relevant.gwt.client.view.search;

import com.fbratu.relevant.gwt.client.listener.ISearchListener;
import com.fbratu.relevant.gwt.client.view.states.ViewState;
import com.fbratu.relevant.gwt.shared.FieldVerifier;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;

/**
 * author: Florin
 */
public class SearchPanel implements ViewState {

    private static final String SEARCH_LOCATION_HINT = "Location";

    private static final String SEARCH_BUTTON_IMG_PATH = "res/search.png";

    // single listener is enough for us
    private ISearchListener searchListener;

    // the search button
    private PushButton searchButton;

    // UI component storing the search location field
    private TextBox searchLocationField;

    // Error UI component - triggered if invalid search parameters
    private Label errorLabel;

    public SearchPanel()  {
    }

    public void create() {
        createSearchButton();
        createSearchLocationField();
        createErrorLabel();
    }

    private void createErrorLabel() {
        errorLabel = new Label();
        RootPanel.get("errorLabelContainer").add(errorLabel);
    }

    private void createSearchButton() {
        // Search image button
        Image searchImg = new Image(SEARCH_BUTTON_IMG_PATH);
        // temporary hack, until a better desing...
        searchImg.setPixelSize(32,32);
        searchButton = new PushButton(searchImg);
        searchButton.addStyleName("searchButton");
        RootPanel.get("searchButtonContainer").add(searchButton);
        searchButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                triggerSearch();
            }
        });
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
