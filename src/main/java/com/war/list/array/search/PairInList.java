package com.war.list.array.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairInList {

	//O(n^2)
	public static boolean findNaive(int[] arr, int sum) {
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				if (arr[i] + arr[j] == sum) {
					return true;
				}
			}
		}
		return false;
	}

	//O(nlog(n))
	public static boolean findTwoPointer(int[] arr, int sum) {
		int size = arr.length;
		int low = 0, high = size - 1;
		Arrays.sort(arr);
		return findTwoPointerInArray(arr, sum, low, high);
	}

	public static boolean findTwoPointerInArray (int[] arr, int sum, int low, int high) {
		while (low < high) {
			int pointSum = arr[low] + arr[high];
			if (pointSum == sum) {
				return true;
			} else if (pointSum < sum) {
				low++;
			} else {
				high--;
			}
		}
		return false;
	}

	//O(n)
	public static boolean findHashSet(int[] arr, int sum) {
		int size = arr.length;
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < size; i++) {
			int temp = sum - arr[i];
			if (s.contains(temp)) {
				return true;
			}
			s.add(arr[i]);
		}
		return false;
	}
}
