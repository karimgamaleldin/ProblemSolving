class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> s = new HashMap<>();
        HashMap<Character, Integer> g = new HashMap<>();
        int x = 0;
        int y = 0;
        int i = 0;
        int j = 0;
        while(i < secret.length() && j < guess.length()){
            char c = secret.charAt(i);
            char d = guess.charAt(j);
            if(c == d) x++;
            else{
                s.put(c, s.getOrDefault(c, 0) + 1);
                g.put(d, g.getOrDefault(d, 0) + 1);
            }
            i++;
            j++;
        }
        while(i < secret.length()) {
            char c = secret.charAt(i++);
            s.put(c, s.getOrDefault(c, 0) + 1);
        }
        while(j < guess.length()) {
            char c = guess.charAt(j++);
            g.put(c, g.getOrDefault(c, 0) + 1);
        }
        for(char c : s.keySet()){
            y += Math.min(s.get(c), g.getOrDefault(c, 0));
        }
        // System.out.println(s);
        // System.out.println(g);
        return x + "A" + y + "B";
    }
}