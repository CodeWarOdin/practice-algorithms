package com.war.list.array;

public class ArrayOperations {
	public static int find(int[] arr, int n, int key) {
		for (int i = 0; i < n; i++) {
			if (key == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	public static int add(int[] arr, int n, int key, int capacity) {
		if (n >= capacity) {
			return n;
		}
		arr[n] = key;
		return (n + 1);
	}

	public static int delete(int[] arr, int n, int key, int capacity) {
		int pos = find(arr, n, key);

		if (pos == -1) {
			System.out.println("Element not found");
			return n;
		}

		//if (n - 1 - pos >= 0) System.arraycopy(arr, pos + 1, arr, pos, n - 1 - pos);
		for (int i = pos; i < n - 1; i++)
			arr[i] = arr[i + 1];
		return n - 1;
	}
}
