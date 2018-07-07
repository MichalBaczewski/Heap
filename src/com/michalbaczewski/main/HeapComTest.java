package com.michalbaczewski.main;

public class HeapComTest {

    public static void main(String[] args) {
        HeapCom heap = new HeapCom(5);
        heap.add(5);
        System.out.println(heap.toString());
        heap.add(6);
        heap.add(7);
        heap.add(2);
        heap.add(3);
        System.out.println(heap.toString());
    }

}
