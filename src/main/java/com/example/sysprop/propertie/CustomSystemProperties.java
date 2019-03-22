package com.example.sysprop.propertie;

import com.example.exception.NotAllowOperationException;
import com.example.sysprop.propertie.listener.ChangeListener;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class CustomSystemProperties extends Properties {

    private Map<String, ChangeListener> changeListenerMap = new LinkedHashMap<>();

    private CustomSystemProperties() {
    }

    public static CustomSystemProperties getInstance() {
        return Nested.INSTANCE;
    }

    @Override
    public synchronized Object setProperty(String key, String value) {
        beforeSetProperty(key, value);
        Object o = super.setProperty(key, value);
        afterSetProperty(key, value);
        return o;
    }

    @Override
    public synchronized Object remove(Object o) {
        String key = String.valueOf(o);
        String value = super.getProperty(key);
        beforeClearProperty(key, String.valueOf(value));
        Object remove = super.remove(o);
        afterClearProperty(key, String.valueOf(remove));
        return remove;
    }

    public void addChangeListener(String listenerName, ChangeListener changeListener) {
        changeListenerMap.put(listenerName, changeListener);
    }

    private void beforeSetProperty(String key, String value) throws NotAllowOperationException {
        for (Map.Entry<String, ChangeListener> entry : this.changeListenerMap.entrySet()) {
            ChangeListener listener = entry.getValue();
            listener.beforeSetProperty(key, value);
        }
    }

    private void beforeClearProperty(String key, String value) throws NotAllowOperationException {
        for (Map.Entry<String, ChangeListener> entry : this.changeListenerMap.entrySet()) {
            ChangeListener listener = entry.getValue();
            listener.beforeClearProperty(key, value);
        }
    }

    private void afterSetProperty(String key, String value) {
        for (Map.Entry<String, ChangeListener> entry : this.changeListenerMap.entrySet()) {
            ChangeListener listener = entry.getValue();
            listener.afterSetProperty(key, value);
        }
    }

    private void afterClearProperty(String key, String value) {
        for (Map.Entry<String, ChangeListener> entry : this.changeListenerMap.entrySet()) {
            ChangeListener listener = entry.getValue();
            listener.afterClearProperty(key, value);
        }
    }

    private static class Nested {
        private static final CustomSystemProperties INSTANCE = new CustomSystemProperties();
    }

}

