class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new LinkedList<>();
        List<Integer> t = new LinkedList<>();
        t.add(1);
        r.add(t);
        for(int i = 1 ; i < numRows ; i++){
            t = new LinkedList<>();
            List<Integer> x = r.get(i - 1);
            for(int j = 0 ; j <= i ; j++){
                if(j > 0 && j < i){
                    t.add(x.get(j - 1) + x.get(j));
                }else t.add(1);
            }
            r.add(t);
        }
        return r;
    }
}