package Backtracking;

import org.junit.jupiter.api.Test;

class SolutionTest {
	private Solution solution;

	SolutionTest() {
		solution = new Solution();
	}
	@Test
	void combinationSum() {
		System.out.print(solution.combinationSum(4));
	}
	@Test
	void combinationSumDP() {
		System.out.print(solution.combinationSumDP(599));
	}
	@Test
	void combinationSumDTM() {
		System.out.print(solution.combinationSumDTM(3));
	}
	@Test
	void combinationSumDP2() {
		System.out.print(solution.combinationSumDP2(9));
	}
}