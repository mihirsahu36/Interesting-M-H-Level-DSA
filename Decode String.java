/*394. Decode String
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Constraints:
1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].*/


class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>(); // to store all integer from String s
        Stack<String> strStack = new Stack<>(); // to store all other characters string other than integer from String s
        String res = ""; // store resultant string
        int n = s.length();
        int i = 0;
        while(i<n){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){ // if character is digit then push it to integer stack
                int num = 0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                intStack.push(num);
                continue;
            }

            else if(ch == '['){ // if character is "[" then push all previous ktimes computed characters tp strStack and reset res to blank
                strStack.push(res);
                res = "";
            }

            else if(ch == ']'){ // if character is "]" then pop the characters till we get "[" and store all characters in temp
                StringBuilder temp = new StringBuilder(strStack.pop());
                int intTimes = intStack.pop();
                for(int j=0;j<intTimes;j++){
                    temp.append(res);
                }
                res = temp.toString();
            }

            else{
                res += ch;
            }
            i++;
        }
        return res;
    }
}
