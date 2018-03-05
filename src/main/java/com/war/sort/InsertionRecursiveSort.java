package com.war.sort;

import com.war.sort.api.Sort;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class InsertionRecursiveSort implements Sort {

    @Override
    public void sort(long[] objects) {
        sort(objects, objects.length);
    }

    private void sort(long[] objects, int length) {
        if(length <= 1){
            return;
        }
        sort(objects, length - 1);
        long value = objects[length - 1];
        int pos = length - 2;
        while(pos >=0 && objects[pos] > value){
            objects[pos + 1] = objects[pos];
            pos--;
        }
        objects[pos + 1] = value;
    }
}
