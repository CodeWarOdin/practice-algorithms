package com.war.sort;

import com.war.sort.api.Sort;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author CodeWarOdin (https://github.com/CodeWarOdin)
 */
public class SortTestUtils {

    static List<Sort> getSortAlgorithmObjects() {
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
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sortList;
    }
}
