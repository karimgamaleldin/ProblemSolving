class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            arr[i] = "" + nums[i];
        }
        Arrays.sort(arr, (a , b) -> {
            String x = a + b;
            String y = b + a;
            return y.compareTo(x);
        });
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}