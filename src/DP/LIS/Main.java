package DP.LIS;

public class Main {
	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		LIS lis = new LIS();
		System.out.println("Length of lis is " + lis.lis(arr, n));

		arr = new int[]{50, 3, 10, 7, 40, 80};
		n = arr.length;
		System.out.println("Length of lis is " + lis.lis(arr, n));
	}
}
