class Solution {
    public int minDays(int n) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        q.add(n);
        int days = 0;
        while(!q.isEmpty()){
            int s = q.size();
            boolean f = false;
            for(int i = 0 ; i < s ;i++){
                int temp = q.remove();
                if(temp == 0){
                    f = true;
                    break;
                }
                if(temp % 2 == 0) {
                    int r = temp / 2;
                    if(!seen.contains(r))
                        q.add(r);
                }
                if(temp % 3 == 0){
                    int r = temp / 3;
                    if(!seen.contains(r))
                        q.add(r);                    
                }
                if(!seen.contains(temp - 1))q.add(temp - 1);
                seen.add(temp);
            }
            if(f) break;
            days++;
        }
        return days;
    }
}