package com.fbratu.relevant.gwt.client;

import com.fbratu.relevant.gwt.shared.ImmoLookupService;
import com.fbratu.relevant.gwt.shared.ImmoLookupServiceAsync;
import com.fbratu.relevant.ws.iface.SearchResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import java.util.List;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class RelevantImmoTest extends GWTTestCase {

  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.fbratu.relevant.gwt.RelevantImmoJUnit";
  }

  /**
   * Tests the FieldVerifier.
   */
  public void testFieldVerifier() {
    assertFalse(FieldVerifier.isValidName(null));
    assertFalse(FieldVerifier.isValidName(""));
    assertFalse(FieldVerifier.isValidName("a"));
    assertFalse(FieldVerifier.isValidName("ab"));
    assertFalse(FieldVerifier.isValidName("abc"));
    assertTrue(FieldVerifier.isValidName("abcd"));
  }

  /**
   * This test will send a request to the server using the greetServer method in
   * ImmoLookupService and verify the response.
   */
  public void testGreetingService() {
    // Create the service that we will test.
    ImmoLookupServiceAsync greetingService = GWT.create(ImmoLookupService.class);
    ServiceDefTarget target = (ServiceDefTarget) greetingService;
    target.setServiceEntryPoint(GWT.getModuleBaseURL() + "relevantimmo/immoLookup");

    // Since RPC calls are asynchronous, we will need to wait for a response
    // after this test method returns. This line tells the test runner to wait
    // up to 10 seconds before timing out.
    delayTestFinish(10000);

    // Send a request to the server.
    greetingService.searchOffers("GWT User", new AsyncCallback<List<SearchResult>>() {
      public void onFailure(Throwable caught) {
        // The request resulted in an unexpected error.
        fail("Request failure: " + caught.getMessage());
      }

      public void onSuccess(List<SearchResult> result) {
        // Now that we have received a response, we need to tell the test runner
        // that the test is complete. You must call finishTest() after an
        // asynchronous test finishes successfully, or the test will time out.
        finishTest();
      }
    });
  }


}
