package com.fbratu.relevant.gwt.client.view.search;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * author: Florin
 */
public class SearchPanel {

    private static final String SEARCH_LOCATION_HINT = "Location";

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
        // TODO Search image button
        final Button searchButton = new Button();
        // We can add style names to widgets
        searchButton.addStyleName("searchButton");
        RootPanel.get("searchButtonContainer").add(searchButton);
    }

    private void initSearchLocationField() {
        final TextBox nameField = new TextBox();
        nameField.setText(SEARCH_LOCATION_HINT);
        nameField.addStyleName("searchLocationHint");
        // blur handler -> set default hint
        nameField.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent blurEvent) {
                String currentValue = nameField.getText();
                if("".equals(currentValue)) {
                   nameField.setText(SEARCH_LOCATION_HINT);
                   // greyed style
                   nameField.removeStyleName("searchLocationFocused");
                   nameField.addStyleName("searchLocationHint");
                }
            }
        });
        // focus handler: if hint mode => switch  to focused mode
        nameField.addFocusHandler(new FocusHandler() {
            @Override
            public void onFocus(FocusEvent focusEvent) {
                String currentValue = nameField.getText();
                if(SEARCH_LOCATION_HINT.equals(currentValue)) {
                    nameField.setValue("");
                    // focused style
                    nameField.addStyleName("searchLocationFocused");
                    nameField.removeStyleName("searchLocationHint");
                }
            }
        });
        RootPanel.get("searchLocationFieldContainer").add(nameField);
    }
}
