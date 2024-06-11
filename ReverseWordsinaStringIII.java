/*Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.*/

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");

        StringBuilder reversedSentence = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            reversedSentence.append(reverseWord(words[i]));
            if (i < words.length - 1) {
                reversedSentence.append(" ");
            }
        }

        return reversedSentence.toString();
    }

    private static String reverseWord(String word) {
        char[] charArray = word.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
    }
