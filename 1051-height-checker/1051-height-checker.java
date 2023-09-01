class Solution {
    public int heightChecker(int[] heights) {
        int[] exp = heights.clone();
        boolean swap = true;
        while(swap){
            swap = false;
            for(int i = 0 ; i < heights.length - 1; i++){
                if(exp[i] > exp[i + 1]){
                    swap = true;
                    int temp = exp[i];
                    exp[i] = exp[i+1];
                    exp[i+1] = temp;
                }
            }
        }
        int ans = 0;
        for(int i = 0 ; i < heights.length; i++){
            if(heights[i] != exp[i]) ans++;
        }
        return ans;
    }
}