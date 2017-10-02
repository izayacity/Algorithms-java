package Trie;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<String>();
		Trie tree = new Trie();
		StringBuilder word = new StringBuilder();

		// insert each word into the trie
		for (String str : wordDict) {
			tree.insert(str);
		}
		searchWord(0, s.length() - 1, s, tree, result, word);
		return result;
	}

	private boolean searchWord(int start, int end, String s, Trie tree, List<String>result, StringBuilder word) {
		for (int i = start; i <= end; i++) {
			String str = s.substring(start, i + 1);
			if (str.length() > tree.getLongest())		continue;

			if (i == end) {
				// append the word string to the result if it's in the trie
				if (tree.contains(str)) {
					word.append(str);
					result.add(word.toString());
					word.setLength(0);
					return true;
				}
				return false;
			} else if (tree.contains(str)) {
				word.append(str);
				word.append(" ");
				// backtrack to 0 to start - 1
				if (!searchWord(i+1, end, s, tree, result, word)) {
					word.setLength(start);
					if (start != 0) {
						word.append(" ");
					}
				}
			}
		}
		return false;
	}
}
