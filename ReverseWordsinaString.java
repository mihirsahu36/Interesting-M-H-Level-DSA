/*A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.*/

class Solution {
    public String reverseWords(String s) {
        String [] words = s.trim().split( "\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if (i > 0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
