package BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author:         Francis Xirui Yang
 * Date:            3/17/19
 * Time:            5:47 PM
 * Version:        1.0
 * Email:           izayacity@gmail.com
 * Description: BinarySearch
 */
class SolutionTest {

	private Solution solution;

	public SolutionTest() {
		this.solution = new Solution();
	}

	@Test
	void searchRange() {
		int[] nums = new int[]{5, 7, 7, 8, 8, 10};
		int[] result = this.solution.searchRange(nums, 8);
		for (int val : result) {
			System.out.println(val);
		}
	}
}