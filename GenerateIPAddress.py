'''A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. 
You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.'''

class Solution(object):
    def check(self, s):
        n = len(s)
        if n < 1 or n > 3:
            return False
        if s[0] == "0" and n > 1:
            return False
        p = int(s)
        if p < 0 or p > 255:
            return False
        return True

    def generate(self, s, n, i, j, k):
        s1 = s[:i+1]        # Substring from the start to i (inclusive)
        s2 = s[i+1:j+1]     # Substring from i+1 to j (inclusive)
        s3 = s[j+1:k+1]     # Substring from j+1 to k (inclusive)
        s4 = s[k+1:]        # Substring from k+1 to the end of the string
        if self.check(s1) and self.check(s2) and self.check(s3) and self.check(s4):
            return s1 + "." + s2 + "." + s3 + "." + s4
        return ""

    def restoreIpAddresses(self, s):
        ans = []
        n = len(s)
        for i in range(n):
            for j in range(i+1, n):
                for k in range(j+1, n):
                    st = self.generate(s, n, i, j, k)
                    if st:
                        ans.append(st)
        return ans
        
