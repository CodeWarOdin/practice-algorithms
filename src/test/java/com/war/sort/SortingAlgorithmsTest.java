package com.war.sort;

import com.war.sort.api.Sort;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.war.sort.SortTestUtils.getSortAlgorithmObjects;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class SortingAlgorithmsTest {

    @Test
    public void sortTest(){
        List<TestInput> testInputs = new ArrayList<>();
        try {
            testInputs = loadTestInput(new FileInputStream(new File("E:\\SynDev\\algorithms\\src\\main\\resources\\com\\war\\sort\\sortingInput.data")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Sort> sortList = getSortAlgorithmObjects();
        for(Sort sort : sortList){
            System.out.println("SORT START " + sort.getClass());
            for(TestInput testInput : testInputs){
                System.out.println("INPUT START ");
                sort.sort(testInput.input);
                System.out.println("INPUT END ");
                Assert.assertTrue(Arrays.equals(testInput.input, testInput.output));
            }
            System.out.println("SORT END " + sort.getClass());
        }
    }

    private List<TestInput> loadTestInput(InputStream in) {
        List<TestInput> testInputs = new ArrayList<>();
        Scanner sc = new Scanner(in);
        int total = sc.nextInt();
        for(int i = 0; i < total; i++){
            int size = sc.nextInt();
            TestInput testInput = new TestInput(size);
            for(int j = 0; j < size; j++){
                testInput.input[j] = sc.nextLong();
            }
            for(int j = 0; j < size; j++){
                testInput.output[j] = sc.nextLong();
            }
            testInputs.add(testInput);
        }
        return testInputs;
    }

    private static class TestInput{
        private long[] input;
        private long[] output;

        private TestInput(int size) {
            input = new long[size];
            output = new long[size];
        }
    }
}
