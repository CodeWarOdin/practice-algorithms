package com.war.sort;

import com.war.sort.api.Sort;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(long[] objects) {
        for(int i = 1; i < objects.length; i++){
            long value = objects[i];
            int pos = i - 1;
            while(pos >=0 && objects[pos] > value){
                objects[pos + 1] = objects[pos];
                pos = pos - 1;
            }
            objects[pos + 1] = value;
        }
    }
}
