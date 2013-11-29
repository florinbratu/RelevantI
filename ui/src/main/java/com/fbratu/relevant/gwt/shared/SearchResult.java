package com.fbratu.relevant.gwt.shared;

import java.io.Serializable;

/**
 * Author: Florin
 */
public class SearchResult implements Serializable{
    private String title;
    private String description;
    private String originalAnnounceLink;

    public SearchResult() {
    }

    public SearchResult(String title, String description, String originalAnnounce) {
        this.title = title;
        this.description = description;
        this.originalAnnounceLink = originalAnnounce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalAnnounceLink() {
        return originalAnnounceLink;
    }

    public void setOriginalAnnounceLink(String originalAnnounceLink) {
        this.originalAnnounceLink = originalAnnounceLink;
    }
}
