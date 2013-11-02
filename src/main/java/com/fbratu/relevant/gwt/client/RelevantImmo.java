package com.fbratu.relevant.gwt.client;

import com.fbratu.relevant.gwt.client.presenter.Presenter;
import com.fbratu.relevant.gwt.client.view.search.SearchPanel;
import com.fbratu.relevant.gwt.shared.ImmoLookupService;
import com.fbratu.relevant.gwt.shared.ImmoLookupServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RelevantImmo implements EntryPoint {

  public void onModuleLoad() {
      SearchPanel searchPanel = new SearchPanel();
      searchPanel.create();
      // init Presenter
      Presenter presenter = new Presenter(searchPanel);
      searchPanel.registerSearchListener(presenter);
  }
}
