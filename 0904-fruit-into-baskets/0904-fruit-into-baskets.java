class Solution {
    public int totalFruit(int[] fruits) {
        int sol = 0;
        int left = 0;
        int right = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < n){
            map.put(fruits[right] , map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2){
                int x = fruits[left];
                int y = map.get(x) - 1;
                if(y == 0) map.remove(x);
                else map.put(x, y);
                left++;
            }
            sol = Math.max(sol, right - left + 1);
            right++;
        }
        return sol;
    }
}