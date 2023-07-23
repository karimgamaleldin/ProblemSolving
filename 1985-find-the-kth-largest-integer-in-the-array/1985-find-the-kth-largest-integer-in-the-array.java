class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a , b) -> mycompare(a , b));
        for(String num : nums){
            pq.add(num);
            if(pq.size() > k) pq.remove();
        }
        return pq.remove();
    }
    public int mycompare(String a , String b){
        if(a.length() == b.length()){
            for(int i = 0 ; i < a.length() ; i++){
                char x = a.charAt(i);
                char y = b.charAt(i);
                if(x != y) return x - y;
            }
            return 0;
        }
        return a.length() - b.length();
    }
}