package Misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
	private Solution solution;

	SolutionTest() {
		solution = new Solution();
	}

	@Test
	void fibonacciTest() {
		// Test case 1
		long expected = 1;
		long actual = solution.fibonacci(2);
		assertEquals(expected, actual);

		// Test case 2
		expected = 55;
		actual = solution.fibonacci(10);
		assertEquals(expected, actual);

		// Test case 3
		expected = 610;
		actual = solution.fibonacci(15);
		assertEquals(expected, actual);

		System.out.println(solution.fibonacci(8181));
	}

}