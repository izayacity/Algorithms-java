package Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	int capacity;
	int min;
	HashMap<Integer, Integer> values;
	HashMap<Integer, Integer> counts;
	HashMap<Integer, LinkedHashSet<Integer>> lists;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		min = 0;
		values = new HashMap<>();
		counts = new HashMap<>();
		lists = new HashMap<>();
	}

	public int get(int key) {
		if(!values.containsKey(key)) {
			return -1;
		}
		int count = counts.get(key);
		counts.put(key, count + 1);
		lists.get(count).remove(key);

		if(count == min && lists.get(count).size() == 0) {
			min = count + 1;
			lists.remove(count);
		}
		if(!lists.containsKey(count + 1)) {
			lists.put(count + 1, new LinkedHashSet<>());
		}
		lists.get(count + 1).add(key);
		return values.get(key);
	}

	public void put(int key, int value) {
		if(values.containsKey(key)) {
			values.put(key, value);
			get(key);
			return;
		}
		if(values.size() == capacity) {
			int least = lists.get(min).iterator().next();
			lists.get(min).remove(least);
			if(lists.get(min).size() == 0) {
				lists.remove(min);
			}
			values.remove(least);
			counts.remove(least);
		}
		values.put(key, value);
		counts.put(key, 1);
		min = 1;
		if(!lists.containsKey(1)) {
			lists.put(1, new LinkedHashSet<>());
		}
		lists.get(1).add(key);
	}
}
