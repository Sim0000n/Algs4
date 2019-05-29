package sort;

public class Main {
    public static void main(String args[]) {

        Double[] a = randomInput(10);
        Heap.sort(a);
        System.out.println(isSorted(a));
    }

    private static Double[] randomInput(int N) {
        Double[] d = new Double[N];
        for (int i = 0; i < N; i++) {
            d[i] = Math.random();
        }
        return d;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
