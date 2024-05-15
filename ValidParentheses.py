'''Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.'''

class Solution:
    def isValid(self, s: str) -> bool:
        matching_bracket = {')': '(', '}': '{', ']': '['}  
        stack = []

        for char in s:
            if char in matching_bracket:
                top_element = stack.pop() if stack else '#'   # "#" is a dummy value assigned if no matching bracket are found
                if matching_bracket[char] != top_element:
                    return False
            else:
                stack.append(char)

        return not stack  #return true if the stack is empty
 
