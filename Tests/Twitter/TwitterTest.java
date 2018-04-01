package Twitter;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwitterTest {

	@Test
	void getNewsFeed() {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		List<Integer> list = twitter.getNewsFeed(1);
		List<Integer> expected = new LinkedList<>();
		expected.add(5);
		assertEquals(list, expected);

		twitter.follow(1, 2);
		twitter.postTweet(2, 6);
		list = twitter.getNewsFeed(1);
		expected.clear();
		expected.add(6);
		expected.add(5);
		assertEquals(list, expected);

		twitter.unfollow(1, 2);
		list = twitter.getNewsFeed(1);
		expected.clear();
		expected.add(5);
		assertEquals(list, expected);
	}
}