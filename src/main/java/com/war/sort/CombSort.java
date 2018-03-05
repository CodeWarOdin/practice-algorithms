package com.war.sort;

import com.war.sort.api.Sort;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class CombSort implements Sort{

    @Override
    public void sort(long[] objects) {
        int n = objects.length;
        int gap = n;
        boolean swapped = true;
        while(gap != 1 || swapped){
            gap = getNextGap(gap);
            swapped = false;
            for(int i = 0; i < n - gap; i++){
                if(objects[i] > objects[i + 1]){
                    swap(objects, i, i +1);
                    swapped = true;
                }
            }
        }
    }

    private int getNextGap(int gap) {
        int nextGap = gap*10/13;
        if(nextGap < 1){
            nextGap = 1;
        }
        return nextGap;
    }
}
