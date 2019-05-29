package sort;

import java.util.*;
/*
* Stable
* O(1) extra space
* O(n^2) worst case performance
* O(n) time when nearly sorted
 */
public class Bubble {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 0; i < N; i++) {
            boolean swapped = false;
            for(int j = N - 1; j > i; j--) {
                if(less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] =  a[j];
        a[j] = t;
    }
    private  static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    private  static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            if(less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }
}
