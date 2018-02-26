package com.war.sort;

import com.war.sort.api.Sort;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class BubbleRecursiveSort implements Sort {

    @Override
    public void sort(long[] objects) {
        sort(objects, objects.length);
    }

    private void sort(long[] objects, int n) {
        boolean swapDone = false;
        for(int i = 0; i < n - 1; i++){
            if(objects[i] > objects[i + 1]){
                swap(objects, i, i + 1);
                swapDone = true;
            }
        }
        if(!swapDone || n == 1){
            return;
        }
        sort(objects, n - 1);
    }
}
