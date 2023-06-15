package org.example.cache.algorithms;

import lombok.AllArgsConstructor;
import org.w3c.dom.Node;

@AllArgsConstructor
public class DoublyLinkedList<Key> {
    DoublyLinkedListNode<Key> head;
    DoublyLinkedListNode<Key> tail;
    int capacity;

    public DoublyLinkedList(int capacity) {
        this.capacity = capacity;
        this.head = new DoublyLinkedListNode<>();
        this.tail = new DoublyLinkedListNode<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addNodeToFront(DoublyLinkedListNode<Key> node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    public DoublyLinkedListNode<Key> addElement(Key key){
        DoublyLinkedListNode<Key> node = new DoublyLinkedListNode<>(key);
        addNodeToFront(node);
        return node;
    }

    public void removeNode(DoublyLinkedListNode<Key> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DoublyLinkedListNode<Key> getLastNode() {
        if (this.tail.prev == head){
            return null;
        }
        return this.tail.prev;
    }


}
