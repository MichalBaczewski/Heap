package com.michalbaczewski.main;

public class HeapComTest {

    public static void main(String[] args) {
        HeapCom heap = new HeapCom(10);
        heap.add(9);
        heap.add(53);
        heap.add(23);
        heap.add(66);
        heap.add(3);
        heap.add(87);
        heap.add(24);
        System.out.println(heap.toString());
        System.out.println(heap.remove());
        System.out.println(heap.toString());
    }

}
