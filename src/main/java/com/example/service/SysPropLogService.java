package com.example.service;

import com.example.model.SysPropLog;

import java.util.List;

public interface SysPropLogService {
    void saveAndFlush(SysPropLog sysPropLog);

    void deleteByKey(String key);

    List<SysPropLog> findAll();
}
