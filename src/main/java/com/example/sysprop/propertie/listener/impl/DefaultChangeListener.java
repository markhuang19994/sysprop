package com.example.sysprop.propertie.listener.impl;

import com.example.exception.NotAllowOperationException;
import com.example.model.SysPropLog;
import com.example.service.SysPropLogService;
import com.example.sysprop.propertie.listener.ChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class DefaultChangeListener implements ChangeListener {

    private static final String PROJECT = "my_first_project";
    private final SysPropLogService sysPropLogService;

    @Autowired
    public DefaultChangeListener(SysPropLogService sysPropLogService) {
        this.sysPropLogService = sysPropLogService;
    }

    @Override
    public void beforeSetProperty(String key, String value) throws NotAllowOperationException {
        if (key.contains("citi")){
            throw new NotAllowOperationException(
                    String.format("%s is not allow to setting", key)
            );
        }
    }

    @Override
    public void afterSetProperty(String key, String value) {
        System.out.println(String.format("Set property: %s=%s", key, value));
        SysPropLog sysPropLog = new SysPropLog();
        sysPropLog.setKey(key);
        sysPropLog.setValue(value);
        sysPropLog.setLastModifyTime(new Timestamp(System.currentTimeMillis()));
        sysPropLog.setLastModifyProject(PROJECT);
        sysPropLogService.saveAndFlush(sysPropLog);
    }

    @Override
    public void beforeClearProperty(String key, String value) throws NotAllowOperationException {
        //ignore
    }

    @Override
    public void afterClearProperty(String key, String value) {
        System.out.println(String.format("Clear property: %s=%s", key, value));
        sysPropLogService.deleteByKey(key);
    }


}
