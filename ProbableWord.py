'''Problem statement
You are given a reference array of strings, ref[] and an array of characters ch[]. Display all the
probable words of the reference array that can be formed using the characters of the array. If no
words are formed display "No"
Input Description: The first line consist of the contents of the array ref[] seperated by comma
and the second line consist of the array of characters seperated by comma.
Output Description:Display the probable words in the ref[] that can be formed using the characters
in the ch[]. If no words can be formed it displays "No"'''



from collections import Counter

def is_word_possible(word, char_count):
    word_count = Counter(word)
    for char, count in word_count.items():
        if char_count[char] < count:
            return False
    return True

def probable_words(ref, ch):
    char_count = Counter(ch)
    result = []
    for word in ref:
        if is_word_possible(word, char_count):
            result.append(word)
    return result if result else "No"

# Example usage:
ref = ["cat", "dog", "tac", "god"]
ch = ['c', 'a', 't', 'd', 'o', 'g']
print(probable_words(ref, ch))  # Output: ['cat', 'dog', 'tac', 'god']
