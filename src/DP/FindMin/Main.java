package DP.FindMin;

public class Main {
	public static void main(String[] args) {
		int arr[] = {3, 1, 4, 2, 2, 1};
		int n = arr.length;
		FindMin fm = new FindMin();
		System.out.print("The minimum difference"+
				" between two sets is " + fm.findMin(arr, n));
	}
}
