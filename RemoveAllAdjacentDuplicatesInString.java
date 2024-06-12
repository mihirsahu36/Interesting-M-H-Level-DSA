/*You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.*/

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (st.isEmpty() || st.peek() != s.charAt(i)) {
                st.push(s.charAt(i));
            } else {
                st.pop();
            }
            i++;
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            char ele = st.pop();
            ans.append(ele);
        }
        return ans.reverse().toString();
    }
}
