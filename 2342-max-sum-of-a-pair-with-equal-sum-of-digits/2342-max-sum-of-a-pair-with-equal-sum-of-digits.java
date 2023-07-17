class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int ans = -1;
        for(int i = 0 ; i < nums.length ; i++){
            int key = getDigitSum(nums[i]);
            if(map.containsKey(key)){ 
                ans = Math.max(ans , map.get(key) + nums[i]);
            }
            map.put(key , Math.max(map.getOrDefault(key , -1) , nums[i]));
        }
        return ans;
    }
    //     Map<Integer , int[]> map = new HashMap<>(); 
    //     for(int i = 0 ; i < nums.length ; i++){
    //         int key = getDigitSum(nums[i]);
    //         if(!map.containsKey(key)) map.put(key , new int[2]);
    //         int[] arr = map.get(key);
    //         if(arr[1] == 0) arr[1] = nums[i];
    //         else if(nums[i] > arr[1]){
    //             arr[0] = arr[1];
    //             arr[1] = nums[i];
    //         }else if(nums[i] > arr[0]){
    //             arr[0] = nums[i];
    //         }
    //     }
    //     List<int[]> x = new ArrayList<>(map.values());
    //     int n = x.size();
    //     int max = -1;
    //     for(int i = 0 ; i < n ; i++){
    //         int[] arr = x.get(i);
    //         if(arr[0] == 0)continue;
    //         max = Math.max(max , arr[0] + arr[1]);
    //     }
    //     return max;
    // }
    public int getDigitSum(int x){
        int r = 0;
        while(x > 0){
            r += x % 10;
            x = x / 10;
        }
        return r;
    }
}