package Trie;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

class SolutionTest {
	@Test
	void wordBreak() {
		Solution trie = new Solution();
		assertEquals(
				Arrays.asList("cat sand dog", "cats and dog"),
				trie.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"))
		);
		assertEquals(
				Arrays.asList("aaa aaaa", "aaaa aaa"),
				trie.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"))
		);
	}
}