class Solution {
    public int maxDistToClosest(int[] seats) {
        ArrayList<Integer> ones = new ArrayList<>();
        int i = 0;
        for(int s : seats){
            if(s == 1) ones.add(i);
            i++;
        }
        int size = seats.length;
        if(ones.size() == 1) return Math.max(size - ones.get(0) - 1, ones.get(0));
        int max = 0;
        for(i = 0; i < ones.size() - 1; i++){
            int a = ones.get(i);
            int b = ones.get(i + 1);
            int bet = (b - a) / 2;
            max = Math.max(bet, max);
        }
        System.out.println(max);
        max = Math.max(Math.max(max, size - ones.get(ones.size() - 1) - 1), ones.get(0));
        System.out.println(max);
        
        return max;
    }
}