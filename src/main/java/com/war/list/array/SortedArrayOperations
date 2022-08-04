package com.war.list.array;

public class SortedArrayOperations {
	public static int find(int[] arr, int low, int high, int key) {
		if (high < low) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (key == arr[mid]) {
			return mid;
		} else if (key > arr[mid]) {
			return find(arr, mid + 1, high, key);
		} else {
			return find(arr, low, mid - 1, key);
		}
	}

	public static int add(int[] arr, int n, int key, int capacity) {
		if (n >= capacity) {
			return n;
		}
		int i;
		for (i = n - 1; i >= 0 && arr[i] > key; i--) {
			arr[i + 1] = arr[i];
		}
		arr[i + 1] = key;
		return n + 1;
	}

	public static int delete(int[] arr, int n, int key, int capacity) {
		int pos = find(arr, 0, n - 1 , key);

		if (pos == -1) {
			System.out.println("Element not found");
			return n;
		}

		//if (n - 1 - pos >= 0) System.arraycopy(arr, pos + 1, arr, pos, n - 1 - pos);
		for (int i = pos; i < n - 1; i++)
			arr[i] = arr[i + 1];
		return n - 1;
	}

	public static void main (String[] args)
	{
		int[] arr = new int[20];
		arr[0] = 12;
		arr[1] = 16;
		arr[2] = 20;
		arr[3] = 40;
		arr[4] = 50;
		arr[5] = 70;
		int capacity = 20;
		int n = 6;
		int i, key = 10;

		System.out.print("Before Insertion: ");
		for (i = 0; i < n; i++)
			System.out.print(arr[i]+" ");

		// Inserting key
		n = add(arr, n, key, capacity);

		System.out.print("\n After Insertion: ");
		for (i = 0; i < n; i++)
			System.out.print(arr[i]+" ");
	}
}
