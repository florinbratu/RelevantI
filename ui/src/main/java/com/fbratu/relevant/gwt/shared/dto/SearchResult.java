package com.fbratu.relevant.gwt.shared.dto;

import java.io.Serializable;

/**
 * Encapsulates a single Search Result to be displayed
 * (not the result details but the entry as displayed in the
 * list of matches)
 *
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

    @Override
    public String toString() {
        return this.title + "|" + this.description + "|" + this.originalAnnounceLink;
    }
}
