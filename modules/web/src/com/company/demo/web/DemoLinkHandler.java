package com.company.demo.web;

import com.haulmont.cuba.web.App;
import com.haulmont.cuba.web.AppUI;
import com.haulmont.cuba.web.sys.LinkHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.WrappedSession;

import java.util.Map;

public class DemoLinkHandler extends LinkHandler {
    public DemoLinkHandler(App app, String action, Map<String, String> requestParams) {
        super(app, action, requestParams);
    }

    @Override
    public boolean canHandleLink() {
        if ("demo".equals(action)) {
            return true;
        }

        return super.canHandleLink();
    }

    @Override
    public void handle() {
        if ("demo".equals(action)) {
            try {
                // open custom main window
                app.navigateTo("demo-screen");
            } finally {
                VaadinRequest request = VaadinService.getCurrentRequest();
                WrappedSession wrappedSession = request.getWrappedSession();
                wrappedSession.removeAttribute(AppUI.LAST_REQUEST_PARAMS_ATTR);
                wrappedSession.removeAttribute(AppUI.LAST_REQUEST_ACTION_ATTR);
            }
        } else {
            super.handle();
        }
    }
}