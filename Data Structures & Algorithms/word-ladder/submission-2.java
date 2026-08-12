class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return count;
                }

                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {

                        if (word.charAt(i) == c) {
                            continue;
                        }

                        String newWord =
                            word.substring(0, i)
                            + c
                            + word.substring(i + 1);

                        if (set.contains(newWord)) {
                            queue.offer(newWord);

                            // Permanently mark visited
                            set.remove(newWord);
                        }
                    }
                }
            }

            count++;
        }

        return 0;
    }
}