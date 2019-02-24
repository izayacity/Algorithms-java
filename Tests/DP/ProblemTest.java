package DP;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Author:         Francis Xirui Yang
 * Date:            2/23/19
 * Time:            3:02 PM
 * Version:        1.0
 * Email:           izayacity@gmail.com
 * Description: DP
 */
class ProblemTest {
	private Problem problem;

	ProblemTest() {
		this.problem = new Problem();
	}

	@Test
	void formNumber() {
		int n = 6;
		List<Integer> list = Arrays.asList(1, 3, 5);
		int res = this.problem.formNumber(n, list);
		Assert.assertEquals(8, res);
	}

	private int[] listToArr(List<Integer> list) {
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	@Test
	void lis() {
		int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
		int[] expected = new int[]{10, 22, 33, 50, 60, 80};
		Assert.assertEquals(expected.length, this.problem.lis(arr));

		int[] arr1 = new int[]{3, 10, 2, 1, 20};
		int[] expected1 = new int[]{3, 10, 20};
		Assert.assertEquals(expected1.length, this.problem.lis(arr1));

		int[] arr2 = new int[]{3, 2};
		Assert.assertEquals(1, this.problem.lis(arr2));

		int[] arr3 = new int[]{50, 3, 10, 7, 40, 80};
		int[] expected3 = new int[]{3, 7, 40, 80};
		Assert.assertEquals(expected3.length, this.problem.lis(arr3));
	}

	@Test
	void eggDropping() {
		int res = this.problem.eggDropping(2, 10);
		Assert.assertEquals(4, res);

		int res1 = this.problem.eggDropping(2, 36);
		Assert.assertEquals(8, res1);
	}
}