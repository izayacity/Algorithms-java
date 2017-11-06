package Backtracking;

import org.junit.jupiter.api.Test;

class SolutionTest {
	private Solution solution;

	SolutionTest() {
		solution = new Solution();
	}
	@Test
	void combinationSum() {
		System.out.print(solution.combinationSum(9));
	}
}