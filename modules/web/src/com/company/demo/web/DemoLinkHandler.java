package com.company.demo.web;

import com.haulmont.cuba.web.App;
import com.haulmont.cuba.web.sys.LinkHandler;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.WrappedSession;

import java.util.Map;

import static com.haulmont.cuba.web.AppUI.LAST_REQUEST_PARAMS_ATTR;

public class DemoLinkHandler extends LinkHandler {
    public DemoLinkHandler(App app, String action, Map<String, String> requestParams) {
        super(app, action, requestParams);
    }

    @Override
    public boolean canHandleLink() {
        // uncomment to enable this window for anonymous open
        /*if ("demo".equals(action)) {
            return true;
        }*/

        return super.canHandleLink();
    }

    @Override
    public void handle() {
        if ("demo".equals(action)) {
            // open custom main window
            app.navigateTo("demo-screen");

            WrappedSession wrappedSession = VaadinSession.getCurrent().getSession();
            wrappedSession.removeAttribute(LAST_REQUEST_PARAMS_ATTR);
        } else {
            super.handle();
        }
    }
}