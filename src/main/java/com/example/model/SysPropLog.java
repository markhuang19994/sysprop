package com.example.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class SysPropLog {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KEY")
    private String key;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "LAST_MODIFY_PROJECT")
    private String lastModifyProject;

    @Column(name = "LAST_MODIFY_TIME")
    private Timestamp lastModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastModifyProject() {
        return lastModifyProject;
    }

    public void setLastModifyProject(String lastModifyProject) {
        this.lastModifyProject = lastModifyProject;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Timestamp lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Override
    public String toString() {
        return "SysPropLog{" +
                "id=" + id +
                ", lastModifyProject='" + lastModifyProject + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
