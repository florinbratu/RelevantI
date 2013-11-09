package com.fbratu.relevant.gwt.client;

import com.fbratu.relevant.gwt.client.view.search.SearchPanelCSS;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Author: Florin
 */
public interface Resources extends ClientBundle {

    @Source("view/search/SearchPanel.css")
    public abstract SearchPanelCSS searchStyle();

//    @Source("../webapp/res/search.png")
//    ImageResource searchButton();

}
