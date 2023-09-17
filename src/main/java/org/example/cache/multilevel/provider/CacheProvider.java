package org.example.cache.multilevel.provider;

import org.example.cache.caches.Cache;
import org.example.cache.multilevel.models.LevelCacheData;
import org.example.cache.multilevel.models.ReadResponse;
import org.example.cache.multilevel.models.WriteResponse;

public class CacheProvider<Key, Value> {
    Cache<Key, Value> curr;
    CacheProvider<Key, Value> next;
    LevelCacheData levelCacheData;

    public WriteResponse set(Key key, Value value) {
        double totalTime = 0;
        Value existingValue = curr.get(key);
        totalTime+=levelCacheData.getReadTime();

        if (existingValue!=value) {
            curr.set(key, value);
            totalTime+= levelCacheData.getWriteTime();
            if (next!=null){
                totalTime+=next.set(key, value).getTotalTime();
            }
        }
        return new WriteResponse(totalTime);
    }

    public ReadResponse<Value> get(Key key) {
        double totalTime = 0;
        Value value = curr.get(key);
        totalTime+= levelCacheData.getReadTime();

        if (value==null) {
            if (next!=null) {
                ReadResponse<Value> response = next.get(key);
                totalTime+=response.getTotalTime();
                if (response.getValue()!=null) {
                    value = response.getValue();
                    curr.set(key, value);
                    totalTime+= levelCacheData.getWriteTime();
                }
            }
        }
        return new ReadResponse<>(value, totalTime);
    }

    public Double getCacheUtilization() {
        return curr.getCacheUtilization();
    }
}
