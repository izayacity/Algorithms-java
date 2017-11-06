package Backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
	private Solution solution;

	SolutionTest() {
		solution = new Solution();
	}
	@Test
	void combinationSum() {
		System.out.print(solution.combinationSum(610));
	}
}