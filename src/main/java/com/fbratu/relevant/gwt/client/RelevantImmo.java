package com.fbratu.relevant.gwt.client;

import com.fbratu.relevant.gwt.client.presenter.Presenter;
import com.fbratu.relevant.gwt.client.view.search.SearchPanel;
import com.google.gwt.core.client.EntryPoint;

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
