package com.example.sysprop.propertie.listener;

import com.example.exception.NotAllowOperationException;

public interface ChangeListener {
    void afterSetProperty(String key, String value);

    void beforeSetProperty(String key, String value) throws NotAllowOperationException;

    void afterClearProperty(String key, String value);

    void beforeClearProperty(String key, String value) throws NotAllowOperationException;
}

