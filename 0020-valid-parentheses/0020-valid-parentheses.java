class Solution {
    public boolean isValid(String s) {
        Map<Character , Character> map = new HashMap<>();
        map.put('(' , ')');
        map.put('{' , '}');
        map.put('[' , ']');
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            char x = s.charAt(i);
            if(map.containsKey(x)) stack.push(x);
            else{
                if(stack.isEmpty()) return false;
                char y = stack.peek();
                if(map.get(y) == x) stack.pop();
                else return false;
            }
        }
        return stack.size() == 0;
    }
}