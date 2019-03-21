package com.example.service.impl;

import com.example.model.SysPropLog;
import com.example.repository.SysPropLogRepository;
import com.example.service.SysPropLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPropLogServiceImpl implements SysPropLogService {

    private final SysPropLogRepository logRepository;

    @Autowired
    public SysPropLogServiceImpl(SysPropLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void saveAndFlush(SysPropLog sysPropLog){
        logRepository.saveAndFlush(sysPropLog);
    }

    @Override
    public void deleteByKey(String key){
        logRepository.deleteByKey(key);
    }

    @Override
    public List<SysPropLog> findAll(){
        return logRepository.findAll();
    }
}
