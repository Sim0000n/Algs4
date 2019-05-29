package sort;

import java.util.*;
/*
* Stable
* O(1) extra space
* O(n^2) worst case performance
* O(n) time when nearly sorted
 */
public class Insertion {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 2; i < N; i++) {
            for(int k = i; k > 1 && less(a[k], a[k - 1]); k--) {
               exch(a, k, k - 1);
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
