package com.war.sort;

import com.war.sort.api.Sort;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class BubbleBreakSort implements Sort {
    @Override
    public void sort(long[] objects) {
        for(int i = 0; i < objects.length - 1; i++){
            boolean swapDone = false;
            for (int j = 0; j < objects.length - i - 1; j++){
                if(objects[j] > objects[j + 1]){
                    swap(objects, j, j + 1);
                    swapDone = true;
                }
            }
            if(!swapDone){
                break;
            }
        }
    }
}
