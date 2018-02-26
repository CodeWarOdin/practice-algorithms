package com.war.sort.api;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public interface Sort {
    void sort(long[] objects);

    default void swap(long[] objects, int i, int j){
        long temp = objects[i];
        objects[i] = objects[j];
        objects[j] = temp;
    }
}
