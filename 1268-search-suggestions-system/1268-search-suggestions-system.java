class TrieNode{
    Map<Character , TrieNode> children;
    List<String> possible;
    public TrieNode(){
        this.children = new HashMap<>();
        this.possible = new LinkedList<>();
    }
    
    public static TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode curr = root;
            for(char c: word.toCharArray()){
                if(!curr.children.containsKey(c)){
                    curr.children.put(c,new TrieNode());
                }
                curr = curr.children.get(c);
                curr.possible.add(word);
                Collections.sort(curr.possible);
                if(curr.possible.size() > 3) curr.possible.remove(curr.possible.size() - 1);
            }
        }
        return root;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = TrieNode.buildTrie(products); 
        List<List<String>> arr = new LinkedList<>();
        TrieNode curr = root;
        int i = 0;
        while(i < searchWord.length()){
            char c = searchWord.charAt(i++);
            if(curr != null) curr = curr.children.get(c);
            if(curr != null) arr.add(curr.possible);
            if(curr == null) arr.add(new LinkedList<>());
            
        }
        return arr;
    }
}