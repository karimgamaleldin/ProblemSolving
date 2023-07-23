class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String , Integer> map = new HashMap<>();
        for(int i = 0 ; i < words.length ; i++){
            map.put(words[i] , map.getOrDefault(words[i] , 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a , b) -> {
            int x = map.get(a);
            int y = map.get(b);
            if(x == y) return b.compareTo(a);
            return x - y;
        });
        for(String s : map.keySet()){
            pq.add(s);
            if(pq.size() > k){
                pq.remove();
            }
        }
        LinkedList<String> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.remove());
        }
        return res;
    }
}