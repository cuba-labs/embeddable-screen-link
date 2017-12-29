package com.company.demo.web.screens;

import com.haulmont.cuba.gui.components.AbstractMainWindow;

import java.util.Map;

public class DemoScreen extends AbstractMainWindow {
    public void handleLink(Map<String, String> requestParams) {
        // implement your additional logic here
        showNotification("Handle link with parameters!");
    }
}