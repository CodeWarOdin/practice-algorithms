package com.war.sort;

import com.war.sort.api.Sort;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class ShellSort implements Sort {

    @Override
    public void sort(long[] objects) {
        int n = objects.length;
        for(int gap = n/2; gap > 0; gap = gap/2){
            for(int i = gap; i < n; i++){
                long temp = objects[i];
                int j;
                for(j = i; j >= gap && objects[j - gap] > temp; j-= gap ){
                    objects[j] = objects[j - gap];
                }
                objects[j] = temp;
            }
        }
    }
}
