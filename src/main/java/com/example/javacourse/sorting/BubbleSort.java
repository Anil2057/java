package com.example.javacourse.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int a[] = {5,4,3,2,1};
		int i,j;
		for(i=0; i<4; i++) {
			for(j=0; j<i; j++) {
				if(a[j]<a[j+1]) {
					//swap
					a[j]+=a[j+1];
					a[j+1]=a[j]-a[j+1];
					a[j]-=a[j+1];
				}
			}
				
			}
	}
}
