package com.war.list.array.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiffSort {

	static void mapSolution(int[] a, int x) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for (Integer n : a) {
			int diff = Math.abs(x - n);
			if (map.containsKey(diff)) {
				map.get(diff).add(n);
			} else {
				List<Integer> l = new ArrayList<>();
				l.add(n);
				map.put(diff, l);
			}
		}
		int idx = 0;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			for (Integer num : entry.getValue()) {
				a[idx++] = num;
			}
		}
	}
}
