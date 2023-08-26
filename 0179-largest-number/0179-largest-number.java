class Solution {
    public String largestNumber(int[] nums) {
        HashMap<Integer , PriorityQueue<String>> map = new HashMap<>();
        for(int num : nums){
            String s = num + "";
            int x = s.charAt(0) - '0';
            if(!map.containsKey(x)) map.put(x , new PriorityQueue<>((a , b) -> {
                String z = a + b;
                String y = b + a;
                return y.compareTo(z);
                
            }));
            map.get(x).add(s);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9 ; i >= 0 ; i--){
            PriorityQueue<String> pq = map.get(i);
            if(pq == null) continue;
            while(!pq.isEmpty()){
                sb.append(pq.poll());
            }
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}