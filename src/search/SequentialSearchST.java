package search;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class SequentialSearchST<Key, Value> {
    private Node first;
    private class Node {
       private Key key;
       private Value value;
       private Node next;
       public Node(Key key, Value value, Node next) {
           this.key = key;
           this.value = value;
           this.next = next;
       }
    }
    public Value get(Key key) {
        for(Node node = first; node != null; node = node.next) {
            if(key.equals(node.key))
                return node.value;
        }
        return null;
    }
    public void put(Key key, Value value) {
        for(Node node = first; node != key; node = node.next) {
            if(key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }
    public int size() {
        int size = 0;
        for(Node node = first; node != null; node = node.next)
            size++;
        return size;
    }
    public void delete(Key key) {
        if(key == null)
            throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }
    public Node delete(Node x, Key key) {
        if(x == null)
            return null;
        if(key.equals(x.key)) {
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
}
