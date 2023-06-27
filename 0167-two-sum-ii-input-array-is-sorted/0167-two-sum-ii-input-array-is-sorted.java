class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int x = numbers[i] + numbers[j];
            if(x == target) break;
            else if(x < target) i++;
            else j--;
        }
        i++; j++;
        return new int[]{i , j};
        
    }
}