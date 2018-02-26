package com.war.sort;

import com.war.sort.api.Sort;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class SelectionSort implements Sort {
    @Override
    public void sort(long[] objects) {
        for(int i = 0; i < objects.length - 1; i++){
            int mixIdx = i;
            for(int j = i + 1; j < objects.length; j++){
                if(objects[j] < objects[mixIdx]){
                    mixIdx = j;
                }
            }
            swap(objects, i, mixIdx);
        }
    }
}
