package com.cssweb.distributedsession;

/**
 * Created by chenhf on 2014/7/10.
 */
public abstract class AbstractCsswebSession implements CsswebSession {
    protected String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
