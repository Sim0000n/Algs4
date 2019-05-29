package search;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    public int size() {
        return N;
    }
    public Value get(Key key) {
        if(N == 0)
            return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0)
            return values[i];
        return null;
    }
    public void put(Key key, Value value) {
        int i = rank(key);
        if(i < N && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }
        for(int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }
    public int rank(Key key) {
        return rank(key, 0, N - 1);
    }
    public int rank(Key key, int lo, int hi) {
        if(hi < lo)
            return lo;
        int mid = lo + (lo + hi) / 2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0)
            return rank(key, lo, mid - 1);
        else if(cmp > 0)
            return rank(key, mid + 1, hi);
        else
            return mid;
    }
}
