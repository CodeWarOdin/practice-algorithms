package com.war.sort;

import com.war.sort.api.Sort;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.war.sort.SortTestUtils.getSortAlgorithmObjects;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class SortPerformanceTest {
    @Test
    public void sortTest(){
        long[] testInputs = new long[20000];
        try {
            testInputs = loadTestInput(new FileInputStream(new File("E:\\SynDev\\algorithms\\src\\main\\resources\\com\\war\\sort\\reverse20K.data")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Sort> sortList = getSortAlgorithmObjects();
        for(Sort sort : sortList){
            long[] objects = Arrays.copyOf(testInputs, 20000);
            long startTime = new Date().getTime();
            try {
                sort.sort(objects);
                long endTime = new Date().getTime();
                System.out.println("TIME CONSUMED " + sort.getClass() + " Time  " + (endTime - startTime));
            }catch (Error e){
                System.out.println("FAILED " + sort.getClass() + " Exception " + e.getMessage());
            }
        }
    }

    private long[] loadTestInput(InputStream in) {
        long[] testInputs = new long[20000];
        Scanner sc = new Scanner(in);
        for(int i = 0; i < 20000; i++){
            testInputs[i] = sc.nextLong();
        }
        return testInputs;
    }
}
