package com.war.list.array.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripleSum {

	public static boolean findNaive(int[] arr, int sum) {
		int size = arr.length;
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					if (arr[i] + arr[j] + arr[k] == sum) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean findTwoPointer(int[] arr, int sum) {
		Arrays.sort(arr);

		int low, high;

		for (int i = 0; i < arr.length - 2; i++) {
			low = i + 1;
			high = arr.length - 1;

			while (low < high) {
				if (arr[i] + arr[low] + arr[high] == sum) {
					return true;
				} else if (arr[i] + arr[low] + arr[high] < sum) {
					low++;
				} else {
					high--;
				}
			}
		}
		return false;
	}

	public static boolean findHashSet(int[] arr, int sum) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			Set<Integer> s = new HashSet<>();
			int part_sum = sum - arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (s.contains(part_sum - arr[j])) {
					return true;
				}
				s.add(arr[j]);
			}
		}
		return false;
	}
}
