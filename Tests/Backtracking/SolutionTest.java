package Backtracking;

import org.junit.jupiter.api.Test;

class SolutionTest {
	private Solution solution;

	SolutionTest() {
		solution = new Solution();
	}
	@Test
	void rollDice() {
		System.out.print(solution.rollDice(4));
	}
}