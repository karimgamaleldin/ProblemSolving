class Trie {
    Map<Character , Trie> children;
    HashSet<String> possible;
    public Trie() {
        children = new HashMap<>();
        possible = new HashSet<>();
    }
    
    public void insert(String word) {
        Trie x = this;
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(!x.children.containsKey(c)){
                x.children.put(c , new Trie());
            }
            x = x.children.get(c);
            x.possible.add(word);
        }
    }
    
    public boolean search(String word) {
        char c = word.charAt(0);
        if(children.containsKey(c)){
            return children.get(c).possible.contains(word);
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Trie x = this;
        for(char c: prefix.toCharArray()){
            if(x.children.containsKey(c)){
                x = x.children.get(c);
            }else{
                return false;
            }
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