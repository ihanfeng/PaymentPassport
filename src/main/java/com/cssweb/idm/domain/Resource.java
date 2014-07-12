package com.cssweb.idm.domain;

import com.cssweb.common.domain.BaseDomain;

import java.io.Serializable;

/**
 * Created by chenhf on 14-2-21.
 */
public class Resource extends BaseDomain {

    private int id;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
