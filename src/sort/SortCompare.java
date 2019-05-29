package sort;


public class SortCompare {
    public static double time(String alg, Double[] a) {
        long startTime = System.currentTimeMillis();
        if (alg.equals("sort.Insertion"))
            Insertion.sort(a);
        if (alg.equals("sort.Selection"))
            Selection.sort(a);
        if (alg.equals("sort.Shell"))
            Shell.sort(a);
        if (alg.equals("sort.Merge"))
            Merge.sort(a);
        if (alg.equals("sort.Quick"))
            Quick.sort(a);
        if (alg.equals("sort.Heap"))
            Heap.sort(a);
        if (alg.equals("sort.Bubble"))
            Bubble.sort(a);
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static double timeRandowInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = Math.random();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandowInput(alg1, N, T);
        double t2 = timeRandowInput(alg2, N, T);
        System.out.printf("%s spend %.3f\n", alg1, t1);
        System.out.printf("%s spend %.3f\n", alg2, t2);
        System.out.printf("For %d random Doubles\n  %s is", N, alg1);
        System.out.printf(" %.3f times faster than %s \n", t2 / t1, alg2);
    }
}
