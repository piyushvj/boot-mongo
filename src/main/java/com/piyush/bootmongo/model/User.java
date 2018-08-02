package com.piyush.bootmongo.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String userId;
    private String name;
    private Date creationDate = new Date();
    private Map<String, String> usetSettings = new HashMap<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, String> getUsetSettings() {
        return usetSettings;
    }

    public void setUsetSettings(Map<String, String> usetSettings) {
        this.usetSettings = usetSettings;
    }
}
