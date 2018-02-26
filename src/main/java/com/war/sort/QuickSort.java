package com.war.sort;

import com.war.sort.api.Sort;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class QuickSort implements Sort {

    @Override
    public void sort(long[] objects) {
        sort(objects, 0, objects.length - 1);
    }

    private void sort(long[] objects, int low, int high) {
        if(low < high){
            int part = partition(objects, low, high);
            sort(objects, low, part - 1);
            sort(objects, part + 1, high);
        }
    }

    private int partition(long[] objects, int low, int high) {
        long pivot = objects[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(objects[j] <= pivot){
                i++;
                swap(objects, i, j);
            }
        }
        swap(objects, i + 1, high);
        return i + 1;
    }
}
