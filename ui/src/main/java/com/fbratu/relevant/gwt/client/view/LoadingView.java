package com.fbratu.relevant.gwt.client.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * This shows a Loading screen. To be used for instance
 * for each async service, when calling the service and
 * while waiting for the reply. Or whenever user needs to
 * wait for something...
 *
 * Author: Florin
 */
public final class LoadingView extends PopupPanel
{
    private final FlowPanel container = new FlowPanel();

    public LoadingView()
    {
        final Image ajaxImage = new Image("res/loading.gif");
        final Grid grid = new Grid(1, 2);
        grid.setWidget(0, 0, ajaxImage);
        grid.setText(0, 1, "Loading...");
        this.container.add(grid);
        add(this.container);
        hide();
    }

}
