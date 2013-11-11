package com.fbratu.relevant.gwt.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * This implements a simple MessageBox to be displayed
 * to the user in case an error occurs
 *
 * Author: Florin
 */
public class ErrorView {

    private final Label errorMessageLabel;

    private final DialogBox popup;

    public ErrorView() {
        // Create a popup dialog box
        popup = new DialogBox();
        popup.setText("Houston, we have a problem");
        popup.setAnimationEnabled(true);
        Button closeButton = new Button("Close");
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new Label("An error has been encountered. Sorry for the inconvenience"));
        errorMessageLabel = new Label();
        errorMessageLabel.setStyleName("serverResponseLabelError");
        dialogVPanel.add(errorMessageLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        popup.setWidget(dialogVPanel);
        popup.hide();
        closeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                popup.hide();
            }
        });
    }

    public void show(Throwable t) {
        show(t.getLocalizedMessage());
    }

    public void show(String errorMessage) {
        errorMessageLabel.setText("Error details: " + errorMessage);
        show();
    }

    public void show() {
        popup.center();
        popup.show();
    }
}
