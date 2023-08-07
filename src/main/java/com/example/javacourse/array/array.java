package com.example.javacourse.array;

public class array {
	public static void main(String[] args) {
		int arr[] = {2,4,5,3,1};   // arr.length
		int sum = 0;
		for (int i=0; i<5; i++) {
			sum+= arr[i];
		}
		int mean = sum/5;
		System.out.println(sum);
		System.out.println(mean);
		
	}
}
