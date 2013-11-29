package com.fbratu.relevant.gwt.server;

import com.fbratu.relevant.gwt.shared.SearchResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter service between the Server-side domain objects(Web Service req/reply)
 * and client-side(GWT) objects.
 *
 * The sole reason this adapter exists is because I don't know how to configure
 * a GWT maven multi-module project :P
 *
 * Author: Florin
 */
public class ServerToClientAdapter {

    public static SearchResult serverToClient(
            com.fbratu.relevant.ws.iface.SearchResult serverSearchResult) {
        SearchResult clientSearchResult = new SearchResult(
                serverSearchResult.getTitle(),
                serverSearchResult.getDescription(),
                serverSearchResult.getOriginalAnnounceLink()
        );
        return clientSearchResult;
    }

    public static List<SearchResult> serverToClient(
            List<com.fbratu.relevant.ws.iface.SearchResult> searchResults) {
        List<SearchResult> ret = new ArrayList<SearchResult>();
        for(com.fbratu.relevant.ws.iface.SearchResult serverResult:searchResults) {
            ret.add(serverToClient(serverResult));
        }
        return ret;
    }
}
