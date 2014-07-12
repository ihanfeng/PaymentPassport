package com.cssweb.distributedsession;

import java.util.List;

/**
 * Created by chenhf on 2014/7/10.
 */
public class SessionRedisImpl extends AbstractCsswebSession implements CsswebSession {

    @Override
    public boolean set(String key, Object obj) {
        /*
        sessionid, key, value
        sessionid, key, value
         */
        return false;
    }

    @Override
    public boolean set(String key, String obj) {
        return false;
    }

    @Override
    public boolean setExpire(String key, int expire) {
        return false;
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public List<String> getKeys(String key) {
        return null;
    }

    @Override
    public boolean remove(String key) {
        return false;
    }

    @Override
    public boolean removeAll(String key) {
        return false;
    }


}
