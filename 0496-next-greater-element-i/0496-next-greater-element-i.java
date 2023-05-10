import java.util.Hashtable;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Hashtable<Integer , Integer> hash = new Hashtable<>();
        int max = nums2[nums2.length - 1];
        hash.put(max , -1);
        for(int i = nums2.length - 2 ; i >= 0 ; i--){
            int x = nums2[i];
            if(x > max){
                hash.put(x , -1);
                max = x;
            }else {
                int j = i;
                while(j < nums2.length && x >= nums2[j]) j++;
                if(j == nums2.length) hash.put(x , -1);
                else hash.put(x , nums2[j]);
            }
        }
        int[] r = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++) r[i] = hash.get(nums1[i]);
        return r;
    }
}