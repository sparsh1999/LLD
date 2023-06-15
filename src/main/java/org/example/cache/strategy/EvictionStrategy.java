package org.example.cache.strategy;

public interface EvictionStrategy<Key> {
    void keyAccessed(Key key);
    Key remove();
}
