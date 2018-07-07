package com.michalbaczewski.main;

import java.util.Arrays;

public class HeapCom {

    private int[] heap;
    private int lastIndex;

    public HeapCom(int size) {
        this.heap = new int[size];
    }

    void add(int value) {
        int index = lastIndex;
        heap[lastIndex++] = value;
        int tmp = 0;
        while (index > 0) {
            if (heap[index] > getParent(index)) {
                tmp = getParent(index);
                heap[getParentIndex(index)] = heap[index];
                heap[index] = tmp;
            }
            index = getParentIndex(index);
        }
    }

    int getParentIndex(int index) {
        if (index != 0) {
            return (index - 1) / 2;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    int getParent(int index) {
        return heap[getParentIndex(index)];
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
