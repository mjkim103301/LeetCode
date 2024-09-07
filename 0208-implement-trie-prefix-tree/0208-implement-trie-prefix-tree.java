class Trie {
    public Trie[] trie;
    public boolean flag;

    public Trie() {
        trie = new Trie[26];
        flag = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(node.trie[index]== null){
                node.trie[index] = new Trie();
            }
            node = node.trie[index];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        for(char ch: word.toCharArray()){
            int index = ch-'a';
            if(node.trie[index]==null){
                return false;
            }
            node = node.trie[index];
        }
        return node.flag;
        
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(char ch: prefix.toCharArray()){
            int index = ch-'a';
            if(node.trie[index]==null){
                return false;
            }
            node = node.trie[index];
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