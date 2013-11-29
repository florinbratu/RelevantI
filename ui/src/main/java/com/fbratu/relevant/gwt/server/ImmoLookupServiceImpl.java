package com.fbratu.relevant.gwt.server;

import com.fbratu.relevant.gwt.shared.ImmoLookupService;
import com.fbratu.relevant.ws.iface.ILookupService;
import com.fbratu.relevant.ws.iface.LookupException;
import com.fbratu.relevant.ws.iface.SearchCriteria;
import com.fbratu.relevant.ws.iface.SearchResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
@Service("immoLookup")
public class ImmoLookupServiceImpl extends RemoteServiceServlet implements
        ImmoLookupService {

    public List<com.fbratu.relevant.gwt.shared.SearchResult>
    searchOffers(String location) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:///C:/dev/projects/RelevantI/" +
                "ui/src/main/webapp/WEB-INF/applicationContext.xml");
        // reference to the WS client
        ILookupService webServiceRef = (ILookupService)context.getBean("seLogerLookupService");
        try {
            SearchCriteria searchCriteria = new SearchCriteria();
            searchCriteria.setLocation(location);
            return  ServerToClientAdapter.serverToClient(
                    webServiceRef.searchOffers(searchCriteria));
        } catch (LookupException e) {
            throw new RuntimeException(e);
        }
    }

}
