class PrefixTree {
    TrieNode root;

    private class TrieNode{
        Map<Character, TrieNode> map = new HashMap<>();
        boolean word = false;
    }

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            cur.map.putIfAbsent(c, new TrieNode());
            cur = cur.map.get(c);
        }
        cur.word = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            if(cur.map.get(c) == null){
                return false;
            }
            cur = cur.map.get(c);
        }
        return cur.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c: prefix.toCharArray()){
            if(cur.map.get(c) == null){
                return false;
            }
            cur = cur.map.get(c);
        }
        return true;
    }
}
