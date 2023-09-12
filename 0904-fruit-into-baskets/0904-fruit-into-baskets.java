class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int r = 0 ; r < fruits.length; r++){
            int x = fruits[r];
            map.put(x, map.getOrDefault(x, 0) + 1);
            while(map.size() == 3){
                int y = fruits[l++];
                map.put(y, map.get(y)-1);
                if(map.get(y) == 0) map.remove(y);
            }
           max = Math.max(max, r - l + 1); 
        }
        return max;
    }
}