class Solution {
    // we can assume that +1 and -1 and 0 of each is a direction
    // check if we reached a deadend then donot from queue
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < deadends.length ; i++){
            if(deadends[i].equals("0000")) return -1;
            set.add(deadends[i]);
        }
        Queue<String> q  = new LinkedList<>();
        int steps = 0;
        q.add("0000");
        set.add("0000");
        while(!q.isEmpty()){
            steps++;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                String temp = q.remove();
                for(String neighbor: neighbors(temp)){
                    if(!set.contains(neighbor)){
                        set.add(neighbor);
                        if(neighbor.equals(target)) return steps;
                        q.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }
    public List<String> neighbors(String node) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int num = (node.charAt(i) - '0');
            for (int change: new int[]{-1, 1}) {
                int x = (num + change + 10) % 10;
                ans.add(node.substring(0, i) + ("" + x) + node.substring(i + 1));
            }
        }
        
        return ans;
    }
}