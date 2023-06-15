package org.example.cache.multilevel;

import org.example.cache.multilevel.models.ReadResponse;
import org.example.cache.multilevel.models.StatsResponse;
import org.example.cache.multilevel.models.WriteResponse;

public interface ILevelCache<Key, Value> {
    // read until its not found, set the above level also
    ReadResponse<Value> get(Key key);

    WriteResponse set(Key key, Value value);

    StatsResponse getStats();
}
