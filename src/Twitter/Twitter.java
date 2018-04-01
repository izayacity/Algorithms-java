package Twitter;
import java.util.*;

public class Twitter {
	private static int timeStamp = 0;
	private Map<Integer, User> userMap;

	class User {
		int id;
		Set<Integer> followed;
		Tweet tweet_head;

		public User(int id) {
			this.id = id;
			followed = new HashSet<>();
			follow(id);
			tweet_head = null;
		}

		public void follow(int id) {
			followed.add(id);
		}

		public void unfollow(int id) {
			followed.remove(id);
		}

		public void post(int id) {
			Tweet t = new Tweet(id);
			t.next = tweet_head;
			tweet_head = t;
		}
	}

	class Tweet {
		int id;
		int time;
		Tweet next;

		public Tweet (int id) {
			this.id = id;
			time = timeStamp++;
			next = null;
		}
	}

	public Twitter () {
		userMap = new HashMap<>();
	}

	public void postTweet(int userId, int tweetId) {
		if(!userMap.containsKey(userId)) {
			User u = new User(userId);
			userMap.put(userId, u);
		}
		userMap.get(userId).post(tweetId);
	}

	public void follow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId)) {
			User u = new User(followerId);
			userMap.put(followerId, u);
		}
		if(!userMap.containsKey(followeeId)) {
			User u = new User(followerId);
			userMap.put(followeeId, u);
		}
		userMap.get(followerId).follow(followeeId);
	}

	public void unfollow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId) || followerId == followeeId) {
			return;
		}
		userMap.get(followerId).unfollow(followeeId);
	}

	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new LinkedList<>();
		if(!userMap.containsKey(userId)) {
			return res;
		}
		Set<Integer> users = userMap.get(userId).followed;
		PriorityQueue<Tweet> q = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

		for(int user : users) {
			Tweet t = userMap.get(user).tweet_head;
			// very important to check whether it's null
			if(t != null) {
				q.add(t);
			}
		}
		int n = 0;
		while(!q.isEmpty() && n < 10) {
			Tweet t = q.poll();
			res.add(t.id);
			n++;
			if(t.next != null) {
				q.add(t.next);
			}
		}
		return res;
	}
}
