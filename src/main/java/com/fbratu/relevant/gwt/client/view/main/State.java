package com.fbratu.relevant.gwt.client.view.main;

/**
 * The View state
 *
 * Author: Florin
 */
public enum State {

    SEARCH_PAGE("search"),

    SEARCH_RESULTS("results");

    private final String name;

    private State(String name) {
        this.name = name;
    }

    public static State getByName(String name) {
        if("search".equals(name)) {
            return SEARCH_PAGE;
        } else if("results".equals(name)) {
            return SEARCH_RESULTS;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
