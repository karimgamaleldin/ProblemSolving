class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++){
            for(int j = i + 1; j < wordList.size(); j++){
                if(differInOne(wordList.get(i) , wordList.get(j))){
                    if(!map.containsKey(wordList.get(i))) map.put(wordList.get(i), new ArrayList<>());
                    if(!map.containsKey(wordList.get(j))) map.put(wordList.get(j), new ArrayList<>());
                    map.get(wordList.get(i)).add(wordList.get(j));
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        map.put(beginWord, new ArrayList<>());
        for(int j = 0; j < wordList.size(); j++){
            if(differInOne(beginWord , wordList.get(j))){
                if(!map.containsKey(wordList.get(j))) map.put(wordList.get(j), new ArrayList<>());
                map.get(wordList.get(j)).add(beginWord);
                map.get(beginWord).add(wordList.get(j));
            }
        }
        // System.out.println(map);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        HashSet<String> seen = new HashSet<>();
        seen.add(beginWord);
        int i = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0 ; j < size; j++){
                String str = q.remove();
                // System.out.println(str);
                List<String> arr = map.get(str);
                for(int k = 0 ; k < arr.size(); k++){
                    // System.out.println("\t" + s);
                    String s = arr.get(k);
                    if(!seen.contains(s)) {
                        q.add(s);
                        seen.add(s);
                    }
                    if(s.equals(endWord)){
                        return i + 1;
                    }
                }
            }
            i++;
        }
        return 0;
    }
    public boolean differInOne(String s, String t){
        boolean f = false;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(f) return false;
                f = true;
            }
        }
        return true;
    }
}