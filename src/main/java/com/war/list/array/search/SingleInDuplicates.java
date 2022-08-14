package com.war.list.array.search;

import java.util.Arrays;

public class SingleInDuplicates {
	static int singleElement(int[] arr, int n)
	{
		int low = 0, high = n - 2;
		/*int mid;

		while (low <= high)
		{
			mid = (low + high) / 2;
			if (arr[mid] == arr[mid ^ 1]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}*/

		for (int mid = (low + high) / 2; low <= high; mid = (low + high) / 2){
			if (arr[mid] == arr[mid ^ 1]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return arr[low];
	}

	// Driver code
	public static void main(String[] args)
	{
		int[] arr = { 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};
		int size = 11;
		Arrays.sort(arr);

		System.out.println(singleElement(arr, size));
	}
}
