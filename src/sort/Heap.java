package sort;

import java.util.*;
/*
* Not stable
* O(1) extra space
* O(n*lg(n)) time
 */
public class Heap {
    public static void sort(Comparable[] a){
        int size = a.length;

        //build heap
        for(int i = size/2 - 1; i >= 0; i--) {
            heapify(a, size, i);
        }

        for(int i = size - 1; i >= 0; i--) {
            exch(a, 0, i);
            heapify(a, i, 0);
        }
    }
    private static void heapify(Comparable[] a, int size, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if(leftChild < size && less(a[largest], a[leftChild])) {
            largest = leftChild;
        }
        if(rightChild < size && less(a[largest], a[rightChild])) {
            largest = rightChild;
        }
        if(largest != i) {
            exch(a, i, largest);
            heapify(a, size, largest);
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