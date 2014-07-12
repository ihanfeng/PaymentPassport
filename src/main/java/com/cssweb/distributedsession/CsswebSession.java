package com.cssweb.distributedsession;

import java.util.List;

/**
 * Created by chenhf on 2014/7/10.
 */
public interface CsswebSession {

    public boolean set(String key, Object obj);
    public boolean set(String key, String obj);

    /**
     * 设置过期时间
     * @param key
     * @param expire
     * @return
     */
    public boolean setExpire(String key, int expire);

    public Object get(String key);

    public List<String> getKeys(String key);

    public boolean remove(String key);
    public boolean removeAll(String key);
}
