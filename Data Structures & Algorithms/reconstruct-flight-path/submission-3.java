class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }

        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", map, route);

        return route;
    }

    private void dfs(
        String airport,
        Map<String, PriorityQueue<String>> map,
        LinkedList<String> route
    ) {
        PriorityQueue<String> destinations = map.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next, map, route);
        }

        route.addFirst(airport);
    }
}