package com.example.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class SysPropLog {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "DATE")
    private Timestamp date;

    @Column(name = "KEY")
    private String key;

    @Column(name = "VALUE")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SysPropLog{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", date=" + date +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
