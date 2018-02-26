package com.war.sort;

import com.war.sort.api.Sort;
import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class SortingAlgorithmsTest {

    @Test
    public void sortTest(){
        List<TestInput> testInputs = null;
        try {
            testInputs = loadTestInput(new FileInputStream(new File("E:\\SynDev\\algorithms\\src\\main\\resources\\com\\war\\sort\\sortingInput.data")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Sort> sortList = getSortAlgorithmObjects();
        for(Sort sort : sortList){
            System.out.println("SORT START " + sort.getClass());
            for(TestInput testInput : testInputs){
                System.out.println("INPUT START " + testInput.input);
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

    private List<Sort> getSortAlgorithmObjects() {
        List<Sort> sortList = new ArrayList<>();

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(), new ResourcesScanner())
                .setUrls(ClasspathHelper.getUrlsForPackagePrefix("com.war.sort")));

        Set<Class<? extends Sort>> subTypes = reflections.getSubTypesOf(Sort.class);
        for(Class<? extends Sort> sortAlgo : subTypes){
            for(Constructor<?> sortConstructor : sortAlgo.getConstructors()){
                if(sortConstructor.getParameterCount() == 0){
                    try {
                        Sort sort = (Sort) sortConstructor.newInstance();
                        sortList.add(sort);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sortList;
    }

    private static class TestInput{
        private long[] input;
        private long[] output;
        private int size;

        private TestInput(int size) {
            input = new long[size];
            output = new long[size];
            this.size = size;
        }
    }
}
