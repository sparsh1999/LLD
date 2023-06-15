package org.example.cache.strategy;


import org.example.cache.algorithms.DoublyLinkedList;
import org.example.cache.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @param <Key>
 */
public class LruEvictionStrategy<Key> implements EvictionStrategy<Key>{

    private final DoublyLinkedList<Key> dll;
    private final Map<Key, DoublyLinkedListNode<Key>> map;

    public LruEvictionStrategy(int capacity) {
        this.dll = new DoublyLinkedList<Key>(capacity);
        this.map = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (map.containsKey(key)){
            DoublyLinkedListNode<Key> node = map.get(key);
            dll.removeNode(node);
            dll.addNodeToFront(node);
        } else {
            DoublyLinkedListNode<Key> node = dll.addElement(key);
            map.put(key, node);
        }
    }

    @Override
    public Key remove() {
        DoublyLinkedListNode<Key> lastNode = dll.getLastNode();
        if (lastNode==null){
            return null;
        }
        dll.removeNode(lastNode);
        map.remove(lastNode.getElement());
        return lastNode.getElement();
    }

}
