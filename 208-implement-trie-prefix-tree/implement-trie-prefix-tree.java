class Trie {
    HashMap<Character, Trie> children;
    boolean isEndOfWord;

    public Trie() {
        children = new HashMap<>();
    }
    
    public void insert(String word) {
        Trie node = this;
        for(char c : word.toCharArray()){
            if(node.children.containsKey(c)){
                node = node.children.get(c);
                continue;
            }
            node.children.put(c, new Trie());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        int lengthCovered = 0;
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(char c : prefix.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */