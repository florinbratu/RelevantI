package com.fbratu.relevant.gwt.client;

import com.fbratu.relevant.gwt.client.presenter.Presenter;
import com.fbratu.relevant.gwt.client.view.main.MainPanel;
import com.fbratu.relevant.gwt.client.view.search.SearchPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RelevantImmo implements EntryPoint {

  public void onModuleLoad() {
      // init View
      MainPanel mainPanel = new MainPanel();
      RootPanel.get().add(mainPanel);
      // init Presenter
      Presenter presenter = new Presenter(mainPanel);
      mainPanel.registerAsListener(presenter);
      // kickstart!
      presenter.start();
  }
}
