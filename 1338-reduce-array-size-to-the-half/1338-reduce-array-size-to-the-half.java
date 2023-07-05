class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer , Pair<Integer,Integer>> map = new HashMap<Integer,Pair<Integer,Integer>>();
        for(int i = 0 ; i < arr.length ; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i] , new Pair(arr[i] , 1));
            }else{
                map.compute(arr[i] , (key , val) ->new Pair<>(val.getKey(), val.getValue() + 1));
            }
        }
        PriorityQueue<Pair<Integer , Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue() , a.getValue()));
        for (Map.Entry<Integer, Pair<Integer, Integer>> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }
        int count = arr.length;
        int r = 0;
        while(count > arr.length/2){
            r++;
            count -= pq.poll().getValue();
        }
        return r;
        
    }
}