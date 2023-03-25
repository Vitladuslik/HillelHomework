package com.template.service.impl;


import com.template.service.Cache;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vitladuslik
 * @version 1.0.1
 */

public class CacheImpl implements Cache {

    private static final Logger infoWriter = LoggerFactory.getLogger("infoWriter");
    private static final Logger errorWriter = LoggerFactory.getLogger("errorWriter");

    @Getter
    Map<String, Map<String, Object>> localCache;

    /**
     * Initialises local cache for further use
     */
    @Override
    public void createCache() {
        localCache = new HashMap<>();
        infoWriter.info("Created cache");
    }

    /**
     * @param cacheName - Name of the cache, you want to put something into
     * @param key - Key which this method will bind with your object
     * @param o - Object which this method is going to store in cache
     * Puts given object into defined cache and binds with selected key.
     */
    @Override
    public boolean put(String cacheName, String key, Object o) {

        try {
            if (localCache == null) {
                createCache();
            }

            if (localCache.get(cacheName) == null) {
                Map<String, Object> temp = new HashMap<>();
                temp.put(key, o);
                localCache.put(cacheName, temp);
            } else {
                localCache.get(cacheName).put(key, o);
            }
            infoWriter.info("Put object " + o.toString() + " in cache named : " + cacheName);
            return true;
        } catch (Exception e) {
            errorWriter.error("Error putting object " + o + " to cache named : " + cacheName);
            return false;
        }
    }
    /**
     * @param cacheName - Name of the cache, you want to get something from
     * @param key - Key which has been bound to your object
     * Gets object with selected key from defined cache.
     */
    @Override
    public Object get(String cacheName, String key) {
        try {
            Object temp = localCache.get(cacheName).get(key);
            infoWriter.info("Got object " + temp + " from cache named : " + cacheName);
            return temp;
        } catch (NullPointerException e) {
            errorWriter.error("Error getting from " + cacheName + " by key " + key);
            return null;
        }

    }
    /**
     * Removes all the mappings from cache, living cache empty.
     */
    @Override
    public boolean clear() {
        try {
            localCache.clear();
            infoWriter.info("Cleared the whole cache");
            return true;
        } catch (Exception e) {
            errorWriter.error("Error clearing the whole cache");
            return false;
        }
    }

    /**
     * @param cacheName - Name of the cache, you want to delete from general cache
     * Removes the defined cache from the whole cache, living all the others untouched
     */
    @Override
    public boolean clear(String cacheName) {
        try {
            localCache.remove(cacheName);
            infoWriter.info("Cleared cache named " + cacheName);
            return true;
        } catch (Exception e) {
            errorWriter.error("Error clearing cache " + cacheName);
            return false;
        }
    }
    /**
     * @param cacheName - Name of the cache, you want to check
     * Checks if cache with selected name exists
     */
    @Override
    public boolean isCacheExist(String cacheName) {
        try {
            boolean exists = localCache.containsKey(cacheName);
            infoWriter.info("Checked if cache named : " + cacheName + " exists : " + exists);
            return exists;
        } catch (Exception e) {
            errorWriter.error("Error checking if cache named " + cacheName + " exists");
            return false;
        }

    }
}
