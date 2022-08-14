package com.war.list.array.sort;

import java.util.Arrays;

public class AlternativeSort {
	static void alternateSort(int[] a) {
		int i = 0, j = a.length - 1;
		Arrays.sort(a);
		while( i < j ) {
			System.out.print(a[j--] + " ");
			System.out.print(a[i++] + " ");
		}
		if ((a.length)%2 == 1) {
			System.out.print( a[i]);
		}
	}
}
