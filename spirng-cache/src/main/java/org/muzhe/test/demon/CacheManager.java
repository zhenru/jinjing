package org.muzhe.test.demon;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author muzhe-wang on  18-8-17 下午4:41.
 */
public class CacheManager<T> {

    private  final Map<String,T> cache = new ConcurrentHashMap<>();

    public T getValue(Object key){
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T value){
        cache.put(key,value);
    }

    public void evictCache(String key){
        if (cache.containsKey(key)){
            cache.remove(key);
        }
    }

    public void evicCache(){
        cache.clear();
    }
}
