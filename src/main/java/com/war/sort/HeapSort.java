package com.war.sort;

import com.war.sort.api.Sort;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class HeapSort implements Sort {

    @Override
    public void sort(long[] objects) {
        int length = objects.length;

        for(int i = length/2 - 1; i >= 0; i--){
            heapIt(objects, length, i);
        }

        for (int i = length - 1; i >= 0; i--){
            swap(objects,0,i);
            heapIt(objects, i, 0);
        }
    }

    private void heapIt(long[] objects, int last, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < last && objects[left] > objects[largest]){
            largest = left;
        }

        if(right < last && objects[right] > objects[largest]){
            largest = right;
        }

        if(largest != i){
            swap(objects, i, largest);
            heapIt(objects, last, largest);
        }
    }
}
