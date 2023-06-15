package org.example.cache.algorithms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DoublyLinkedListNode<Key> {
    @Getter Key element;
    DoublyLinkedListNode<Key> next;
    DoublyLinkedListNode<Key> prev;

    public DoublyLinkedListNode(Key key){
        this.element = key;
        this.next = this.prev = null;
    }
}
