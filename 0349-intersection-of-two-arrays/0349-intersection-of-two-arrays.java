class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num: nums1) set1.add(num);
        for(int num: nums2) set2.add(num);
        if(set1.size() > set2.size())
        {
            HashSet<Integer> temp = set1;
            set1 = set2;
            set2 = temp;
        }
        int[] output = new int[set1.size()];
        int i = 0;
        for(int s: set1){
            if(set2.contains(s)) output[i++] = s;
        }
        return Arrays.copyOf(output, i);
    }
}