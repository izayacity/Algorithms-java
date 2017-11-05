package Trie;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
	@Test
	void contains() {
		Trie tree = new Trie();
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		for (String str : wordDict) {
			tree.insert(str);
		}
		assertEquals(true, tree.contains("cats"));
		assertEquals(true, tree.contains("sand"));
		assertEquals(false, tree.contains("ca"));
		assertEquals(false, tree.contains("da"));
	}
}