package org.example.cache.multilevel;

import org.example.cache.multilevel.ILevelCache;
import org.example.cache.multilevel.models.ReadResponse;
import org.example.cache.multilevel.models.StatsResponse;
import org.example.cache.multilevel.models.WriteResponse;
import org.example.cache.multilevel.provider.CacheProvider;

public class DefaultLevelCache<Key, Value> implements ILevelCache<Key, Value> {
    CacheProvider<Key, Value> cacheProvider;

    @Override
    public ReadResponse<Value> get(Key key) {
        return cacheProvider.get(key);
    }

    @Override
    public WriteResponse set(Key key, Value value) {
        return cacheProvider.set(key, value);
    }

    @Override
    public StatsResponse getStats() {
        return null;
    }
}
