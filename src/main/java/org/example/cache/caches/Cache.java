package org.example.cache.caches;

import org.example.cache.strategy.EvictionStrategy;
import org.example.cache.strategy.LruEvictionStrategy;

public class Cache<Key, Value>{
    EvictionStrategy<Key> evictionStrategy;
    Storage<Key, Value> storage;

    public Value get(Key key){
        return null;
    }

    public void set(Key key, Value value){

    }

    public double getCacheUtilization() {
        //this.storage.getCacheUtilization();
        // map.size()/totalSize()
        return 0;
    }
}
