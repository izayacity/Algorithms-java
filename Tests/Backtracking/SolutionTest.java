package Backtracking;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SolutionTest {
	private Solution solution;

	SolutionTest() {
		solution = new Solution();
	}
	@Test
	void rollDice() {
		Assert.assertEquals(5, solution.rollDice(4));
	}

	@Test
	void findWays() {
		Assert.assertEquals(0, solution.findWays(4, 2, 1));
		Assert.assertEquals(2, solution.findWays(2, 2, 3));
		Assert.assertEquals(21, solution.findWays(6, 3, 8));
		Assert.assertEquals(4, solution.findWays(4, 2, 5));
		Assert.assertEquals(6, solution.findWays(4, 3, 5));
	}
}