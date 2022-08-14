package com.war.list.array.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortWave {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void sort(int[] a) {
		int n = a.length;
		Arrays.sort(a);
		for(int i = 0; i < n - 1; i = i + 2)
			swap(a, i, i+1);
	}

	static void sortSwap(int[] a) {
		int n = a.length;
		for(int i = 0; i < n - 1; i = i + 2) {
			if (i > 0 && a[i - 1] > a[i])
				swap(a, i, i - 1);
			if (i < n - 1 && a[i + 1] > a[i])
				swap(a, i, i + 1);
		}
	}

	public static void main(String[] args) {
		int[] a = {90, 95, 92, 93, 10, 49, 1, 5, 2, 23};
		//95, 90, 93, 92, 49, 10, 5, 1, 23, 2
		//95, 90, 93, 10, 92, 1, 49, 2, 23, 5
		sortSwap(a);
		System.out.println(Arrays.toString(a));
	}
}
