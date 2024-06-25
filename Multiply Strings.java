/*Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.*/

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {      //Iterate from right to left
            for (int j = n - 1; j >= 0; j--) {    //Iterate from right to left
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');    //Convert character at ith position to integer
                int p1 = i + j, p2 = i + j + 1;    //p1 is position of current and p2 is position of carry
                int sum = mul + result[p2];

                result[p1] += sum / 10;      //sum / 10 calculates the carry, which is added to result[p1]
                result[p2] = sum % 10;      //sum % 10 calculates the current digit, which is stored in result[p2]
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {    //remove leading zeros
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
