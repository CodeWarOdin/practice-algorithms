package com.war.list.array.search;

public class SubArraySum {

	static void doubleLoop(int[] a, int sum) {
		int cSum = 0, n = a.length;
		for(int i = 0; i < n; i++) {
			cSum = a[i];
			for (int j = i + 1; j <=n; j++) {
				if (cSum == sum) {
					System.out.println(" Sum found between indexes " + i + " and " + (j - 1));
				} else if (cSum > sum || j == n) {
					break;
				}
				cSum += a[j];
			}
		}
		System.out.println(" Sum not found");
	}

	static void backTrack(int[] a, int sum) {
		int cSum = a[0], n = a.length, start =0;
		for(int i = 1; i <= n; i++) {
			while (cSum > sum && start < i-1) {
				cSum -= a[start];
				start++;
			}
			if (cSum == sum) {
				System.out.println(" Sum found between indexes " + start + " and " + (i - 1));
				return;
			}
			if (i < n) {
				cSum += a[i];
			}
		}
		System.out.println(" Sum not found");
	}
}
