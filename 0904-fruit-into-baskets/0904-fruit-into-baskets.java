class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int left = 0;
        int sol = 0;
        int val = 0;
        for(int right = 0 ; right < fruits.length ; right++){
            int temp = map.containsKey(fruits[right]) ? map.get(fruits[right]) + 1 : 1;
            map.put(fruits[right] , temp);
            val++;
            while(left < right && map.size() > 2){
                if(map.get(fruits[left]) <= 1) map.remove(fruits[left]);
                else map.put(fruits[left] , map.get(fruits[left]) - 1);
                val--;
                left++;
            }
            sol = Math.max(sol , val);
        }
        return sol;
    }
}