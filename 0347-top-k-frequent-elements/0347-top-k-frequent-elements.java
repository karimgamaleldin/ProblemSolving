class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            map.computeIfPresent(nums[i] , (key , value) -> value+1);
            if(!map.containsKey(nums[i])) map.put(nums[i] , 1);
        }
        int[] r = new int[k]; 
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue());       
        for(Map.Entry<Integer, Integer> ele: map.entrySet()){
            pq.add(ele);
        }
        for(int i = 0 ; i < k ; i++){
            r[i] = pq.poll().getKey();
        }
        return r;
    }
}