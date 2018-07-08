package com.michalbaczewski.main;

import java.util.Arrays;

public class HeapCom {

    private int[] heap;
    private int lastIndex;
    private int index;

    public HeapCom(int size) {
        this.heap = new int[size];
    }

    void add(int value) {
        int currentIndex = lastIndex;
        heap[lastIndex++] = value;
        int tmp = 0;
        while (currentIndex > 0) {
            if (heap[currentIndex] > getParent(currentIndex)) {
                tmp = getParent(currentIndex);
                heap[getParentIndex(currentIndex)] = heap[currentIndex];
                heap[currentIndex] = tmp;
            }
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public int remove() {
        if (!hasNodes()) {
            throw new IndexOutOfBoundsException();
        }
        int elementToRemove = heap[0];
        int currentIndex = 0;
        int greaterChildIndex = getGreaterChildIndex(0);
        int lastValue = heap[--lastIndex];
        while (greaterChildIndex < lastIndex && heap[greaterChildIndex] > lastValue) {
            heap[currentIndex] = heap[greaterChildIndex];
            currentIndex = greaterChildIndex;
            greaterChildIndex = getGreaterChildIndex(currentIndex);
        }
        heap[currentIndex] = lastValue;
        return elementToRemove;
    }

    private int getGreaterChildIndex(int index) {
        if (hasRightChild(index)) {
            return getLeftChildIndex(index) > getRightChild(index)
                    ? getLeftChildIndex(index) : getRightChildIndex(index);
        } else if (hasLeftChild(index)) {
            return getLeftChildIndex(index);
        } else {
            return lastIndex + 1;
        }
    }

    private int getParentIndex(int index) {
        if (index != 0) {
            return (index - 1) / 2;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    int getParent(int index) {
        return heap[getParentIndex(index)];
    }

    int getLeftChildIndex(int index) {
        if (hasLeftChild(index)) {
            return 2 * index + 1;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    int getRightChildIndex(int index) {
        if (hasRightChild(index)) {
            return 2 * index + 2;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private int getRightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    public boolean hasLeftChild(int index) {
        return (2 * index + 1) < lastIndex;
    }

    private boolean hasRightChild(int index) {
        return (2 * index + 2) < lastIndex;
    }

    private boolean hasNodes() {
        return lastIndex > 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap, 0, lastIndex));
    }
}
