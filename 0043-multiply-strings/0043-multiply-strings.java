class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] product = new int[m + n]; // Store the product of each digit multiplication
        
        // Perform the digit multiplication and addition
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int temp = x * y + product[i + j + 1]; // Add the previous product value
                product[i + j + 1] = temp % 10; // Update the current position
                product[i + j] += temp / 10; // Update the carry to the next position
            }
        }
        
        // Convert the product array to a string
        StringBuilder sb = new StringBuilder();
        for (int digit : product) {
            if (!(sb.length() == 0 && digit == 0)) { // Skip leading zeros
                sb.append(digit);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString(); // Handle the case when the result is "0"
    }
}
