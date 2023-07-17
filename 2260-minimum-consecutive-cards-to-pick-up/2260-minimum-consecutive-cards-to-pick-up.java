class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < cards.length ; i++){
            if(map.containsKey(cards[i])){
                int left = map.get(cards[i]);
                min = Math.min(min , i - left + 1);
            }
            map.put(cards[i] , i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}