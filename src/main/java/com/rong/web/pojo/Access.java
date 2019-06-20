package com.rong.web.pojo;

public class Access {
    private Integer id;

    private String accessName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName == null ? null : accessName.trim();
    }
}