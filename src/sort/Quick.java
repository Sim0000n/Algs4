package sort;

import java.util.*;
/*
* Not stable
* O(lgn) extra space
* Worst case performance O(n^2)
* Best case performance O(n*lgn) or O(n) with three-way partition
* Average case performance O(n*lgn)
 */
public class Quick {
    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi){
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i], v)) {
                if(i == hi) {
                    break;
                }
            }
            while(less(v, a[--j])) {
                if(j == lo) {
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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