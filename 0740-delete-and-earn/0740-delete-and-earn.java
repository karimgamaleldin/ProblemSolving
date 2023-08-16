class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer , Integer> countMap = new HashMap<>();
        int n = nums.length;
        int[] tab = new int[n];
        Arrays.sort(nums);
        for(int num : nums){
            countMap.put(num , countMap.getOrDefault(num , 0) + 1);
        }
        for(int i = n - 1 ; i >= 0 ; i--){
            if(i != 0 && nums[i-1] == nums[i]) continue;
            int t = countMap.get(nums[i]);
            int u = countMap.containsKey(nums[i] + 1) ? countMap.get(nums[i] + 1) : 0 ;
            int x = t * nums[i];
            if(t + i + u < n){
                x += tab[t + i + u];
            }
            if(u != 0){
                x = Math.max(x , tab[i + t]);
            }
            tab[i] = x;
        }
        return tab[0];
    }
    // Memoization
//     public int deleteAndEarn(int[] nums) {
//         HashMap<Integer , Integer> countMap = new HashMap<>();
//         HashMap<Integer , Integer> memo = new HashMap<>();
//         Arrays.sort(nums);
//         for(int num : nums){
//             countMap.put(num , countMap.getOrDefault(num , 0) + 1);
//         }
//         return dp(0 , nums , countMap , memo);
//     }
    
//     public int dp(int i , int[] nums , HashMap<Integer , Integer> counts , HashMap<Integer , Integer> memo){
//         if(i >= nums.length) return 0;
//         else if(memo.containsKey(nums[i])) return memo.get(nums[i]);
//         int x = counts.get(nums[i]);
//         int y = counts.containsKey(nums[i] + 1) ? counts.get(nums[i] + 1) : 0;
//         int take = nums[i] * x + dp(i + x + y , nums , counts , memo);
//         int skip = dp(i + x , nums , counts , memo);
//         memo.put(nums[i] , Math.max(take , skip));
//         return memo.get(nums[i]);
//     }
}