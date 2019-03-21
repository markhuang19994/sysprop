package com.example.repository;

import com.example.model.SysPropLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface SysPropLogRepository extends JpaRepository<SysPropLog, Long> {
    @Modifying
    @Transactional
    void deleteByKey(String key);
}
