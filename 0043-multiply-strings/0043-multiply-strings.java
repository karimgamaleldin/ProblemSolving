class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] product = new int[m + n]; 
        
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int temp = x * y + product[i + j + 1]; 
                product[i + j + 1] = temp % 10; 
                product[i + j] += temp / 10; 
            }
        }
        
        // Convert the product array to a string
        StringBuilder sb = new StringBuilder();
        for (int digit : product) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
