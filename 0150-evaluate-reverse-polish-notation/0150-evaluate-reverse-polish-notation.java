class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0 ; i < tokens.length ; i++){
            String x = tokens[i];
            if(x.equals("+")){
                int a = s.pop();
                int b = s.pop();
                s.push(a+b);
            }
            else if (x.equals("-")){
                int a = s.pop();
                int b = s.pop();
                s.push(b-a);
            }
            else if (x.equals("*")){
                int a = s.pop();
                int b = s.pop();
                s.push(a*b);
            }
            else if (x.equals("/")){
                int a = s.pop();
                int b = s.pop();
                s.push(b/a);
            }
            else s.push(Integer.parseInt(x));
        }
        return s.pop();
    }
}