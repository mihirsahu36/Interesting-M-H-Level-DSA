/*You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars (each character can only be used once).
Return the sum of lengths of all good strings in words.*/

class Solution {
  public int countCharacters(String[] words, String chars) {
    int ans = 0; 
    int[] count = new int[26];  // Array of 26 length to store all alphabets

    for (int i = 0; i < chars.length(); i++) {
      char c = chars.charAt(i);
      count[c - 'a']++;    //Keep track of count like if c==a the c value is 97 so 97 - 97 = 0 a will be stored in 0 index
    }

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      int[] tempCount = count.clone();    // Clone the count array to a temporary array to check the current word without altering the original count

      boolean canForm = true;

      for (int j = 0; j < word.length(); j++) {
        char c = word.charAt(j);
        if (--tempCount[c - 'a'] < 0) {     // It keeps track if the array frequency for the chars is 0 or less than the word is not a good word
          canForm = false;
          break;
        }
      }

      if (canForm)
        ans += word.length();
    }

    return ans;
  }
}
