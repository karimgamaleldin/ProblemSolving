class Solution {
    public long distinctNames(String[] ideas) {
        // HashMap<String , Long> map = new HashMap<>();
        // HashMap<Character , Long> map2 = new HashMap<>();
        // for(int i = 0 ; i < ideas.length ; i++){
        //     if(!map.containsKey(ideas[i].substring(1))){
        //         map.put(ideas[i].substring(1) , 1L);
        //     }else{
        //         map.computeIfPresent(ideas[i].substring(1),
        //                            (key, val) -> val + 1);
        //     }
        //     if(!map2.containsKey(ideas[i].charAt(0))){
        //         map2.put(ideas[i].charAt(0) , 1L);
        //     }else{
        //         map2.computeIfPresent(ideas[i].charAt(0),
        //                            (key, val) -> val + 1);
        //     }
        // }
        // long total = 0;
        // for(int i = 0 ; i < ideas.length ; i++){
        //     System.out.println(ideas.length - map.get(ideas[i].substring(1)) - map2.get(ideas[i].charAt(0)) + 1);
        //     total += (ideas.length - map.get(ideas[i].substring(1)) - map2.get(ideas[i].charAt(0)) + 1);
        // }
        long total = 0;
        HashMap<Character , HashSet<String>> map = new HashMap<>();
        for(int i = 0 ; i < ideas.length ; i++){
            if(!map.containsKey(ideas[i].charAt(0))){
                HashSet<String> s = new HashSet<String>();   
                s.add(ideas[i].substring(1));
                map.put(ideas[i].charAt(0) , s);
            }else{
                map.get(ideas[i].charAt(0)).add(ideas[i].substring(1));
            }
        }
        for(Character key : map.keySet()){
            HashSet<String> set1 = map.get(key);
            for(Character key2: map.keySet()){
                if(key == key2) continue;
                HashSet<String> set2 = map.get(key2);
                int common = 0;
                for(String element: set1){
                    if(set2.contains(element)) common++;
                }
                total += (set1.size() - common) * (set2.size() - common);
            }
        }
        
        return total;
    }
}