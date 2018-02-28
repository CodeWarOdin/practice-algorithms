package com.war.sort;

import com.war.sort.api.Sort;

import java.util.Arrays;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class RadixSort implements Sort {

    @Override
    public void sort(long[] objects) {
        long max = getMax(objects);
        for(int i = 1; max/i > 0; i*=10){
            sort(objects, i);
        }
    }

    private void sort(long[] objects, int div) {

        int[] count = getCountOfSingleDigits(objects, div);
        long[] output = getOutputOrderOfDigit(objects, div, count);

        for (int i = 0; i < objects.length; i++){
            objects[i] = output[i];
        }
    }

    private long[] getOutputOrderOfDigit(long[] objects, int div, int[] count) {
        long[] output = new long[objects.length];
        for (int i = objects.length - 1; i >= 0; i--){
            output[count[ (int)((objects[i]/div)%10) ] - 1] = objects[i];
            count[ (int)((objects[i]/div)%10) ]--;
        }
        return output;
    }

    private int[] getCountOfSingleDigits(long[] objects, int div) {
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for(int i = 0; i < objects.length; i++){
            count[ (int)((objects[i]/div)%10) ]++;
        }

        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        return count;
    }

    private static long getMax(long[] objects) {
        long max = objects[0];
        for(int i = 1; i < objects.length; i++){
            if(max < objects[i]){
                max = objects[i];
            }
        }
        return max;
    }
}
