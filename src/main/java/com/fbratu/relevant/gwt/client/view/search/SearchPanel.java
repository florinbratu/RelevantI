package com.fbratu.relevant.gwt.client.view.search;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.*;

/**
 * author: Florin
 */
public class SearchPanel {

    private static final String SEARCH_LOCATION_HINT = "Location";

    private static final String SEARCH_BUTTON_IMG_PATH = "res/search.png";

    public SearchPanel()  {
    }

    /**
     * Load UI components
     */
    public void init() {
        initSearchButton();
        initSearchLocationField();
    }

    private void initSearchButton() {
        // Search image button
        Image searchImg = new Image(SEARCH_BUTTON_IMG_PATH);
        // temporary hack, until a better desing...
        searchImg.setPixelSize(32,32);
        final PushButton searchButton = new PushButton(searchImg);
        searchButton.addStyleName("searchButton");
        RootPanel.get("searchButtonContainer").add(searchButton);
    }

    private void initSearchLocationField() {
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
    }
}
