package com.war.sort;

import com.war.sort.api.Sort;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class MergeSort implements Sort {

    @Override
    public void sort(long[] objects) {
        sort(objects, 0, objects.length - 1);
    }

    private void sort(long[] objects, int l, int r) {
        if(l < r){
            int m = (l + r)/2;
            sort(objects, l, m);
            sort(objects,m + 1, r);

            merge(objects, l, m, r);
        }
    }

    private void merge(long[] objects, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        long[] left = new long[n1];
        long[] right = new long[n2];

        for(int i = 0; i < n1; i++){
            left[i] = objects[l + i];
        }
        for(int i = 0; i < n2; i++){
            right[i] = objects[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                objects[k] = left[i];
                i++;
            }else{
                objects[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            objects[k] = left[i];
            i++;
            k++;
        }
        while(j < n2){
            objects[k] = right[j];
            j++;
            k++;
        }
    }
}
