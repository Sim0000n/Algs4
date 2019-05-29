package search;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;
        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
    public int size() {
        return size(root);
    }
    public int size(Node x) {
        if(x == null)
            return 0;
        return x.N;
    }
    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            return get(x.left, key);
        } else if(cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }
    private Node put(Node x, Key key, Value value) {
        if(x == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = put(x.left, key, value);
        else if(cmp > 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if(x.left == null)
            return x;
        else
            return min(x.left);
    }
    public Key floor(Key key) {
        return floor(root, key).key;
    }
    private Node floor(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        else if(cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t != null)
            return t;
        else
            return x;
    }
    public Key select(int k) {
        return select(root, k).key;
    }
    private Node select(Node x, int k) {
        if(x == null)
            return null;
        int t
    }
}
