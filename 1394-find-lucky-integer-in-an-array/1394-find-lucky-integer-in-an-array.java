class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer , Integer> count = new HashMap<Integer , Integer>();
        for(int i = 0 ; i < arr.length ; i++) count.put(arr[i] , count.getOrDefault(arr[i] , 0) + 1);
        int ans = -1;
        for(int x : count.keySet()){
            if(count.get(x) == x && x > ans) ans = x;
        }
        return ans;
    }
}