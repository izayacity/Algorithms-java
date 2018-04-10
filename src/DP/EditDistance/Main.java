package DP.EditDistance;

public class Main {
	public static void main(String args[]) {
		String str1 = "sunday";
		String str2 = "saturday";
		EditDistance ed = new EditDistance();
		System.out.println(ed.editDist(str1, str2, str1.length(), str2.length()));
	}
}
