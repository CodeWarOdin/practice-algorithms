package com.war.list.array;

public class LengthOfNumber {

	static int findIndex(int[] a, int x) {
		int l = 0, h = a.length - 1, m = (l + h)/2;
		while (l <= h) {
			if (a[m] == x)
				return m;
			else if (a[m] > x)
				h = m - 1;
			else
				l = m + 1;
			m = (l + h) / 2;
		}
		return -1;
	}

	static int findLow(int[] a, int idx) {
		int l = 0, h = idx, m = (l + h)/2;
		if (a[l] == a[idx])
			return l;
		while (l < h) {
			if (a[m] == a[idx] && a[m - 1] != a[idx])
				return m;
			else if (a[m] == a[idx])
				h = m - 1;
			else
				l = m + 1;
			m = (l + h) / 2;
		}
		return m;
	}

	static int findHigh(int[] a, int idx) {
		int l = idx, h = a.length - 1, m = (l + h)/2;
		if (a[h] == a[idx])
			return l;
		while (l < h) {
			if (a[m] == a[idx] && a[m + 1] != a[idx])
				return m;
			else if (a[m] == a[idx])
				l = m + 1;
			else
				h = m - 1;
			m = (l + h) / 2;
		}
		return m;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};

		findLength(arr, 2);
		findLength(arr, 3);
		findLength(arr, 4);
		findLength(arr, 7);
		findLength(arr, 8);
	}

	private static void findLength(int[] arr, int x) {
		int idx = findIndex(arr, x);
		if (-1 == idx) {
			System.out.println("Number " + x + " not present.");
		} else {
			int l = findLow(arr, idx);
			int h = findHigh(arr, idx);
			System.out.println("Length of number " + arr[idx] + " is " + (h - l + 1));
		}
	}
}
