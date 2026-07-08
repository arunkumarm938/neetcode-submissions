class Twitter {
    int timer;
    Map<Integer, Set<Integer>> fMap;
    Map<Integer, PriorityQueue<int[]>> tMap;

    public Twitter() {
        timer = 0;
        fMap = new HashMap<>();
        tMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        follow(userId, userId);

        if (!tMap.containsKey(userId)) {
            PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
            tMap.put(userId, q);
        }

        insertTweet(userId, tweetId, tMap.get(userId));
    }

    private void insertTweet(int userId, int tweetId, PriorityQueue<int[]> pq) {
        timer++;
        pq.offer(new int[]{tweetId,timer});
        System.out.println("Tweet Added for "+userId+" "+tweetId);
        if (pq.size() > 10) {
            pq.poll();
        }
    }
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> set = fMap.get(userId);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));

        for (int i : set) {
            for (int[] j : tMap.get(i)) {
                System.out.println(j+" jj ");
                pq.offer(j);
            }
        }
        List<Integer> sortedList = new ArrayList<>();
        while (!pq.isEmpty() && sortedList.size() < 10) {
            sortedList.add(pq.poll()[0]);
        }
        return sortedList;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> set;

        if (fMap.containsKey(followerId)) {
            set = fMap.get(followerId);
        } else {
            set = new HashSet<Integer>();
            fMap.put(followerId, set);
        }
        set.add(followeeId); 
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        Set<Integer> set = fMap.get(followerId);
        set.remove(followeeId);
    }
}