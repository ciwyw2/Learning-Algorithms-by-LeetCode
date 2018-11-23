class Solution:
    def longestPalindrome(self, s):
        """
        最长回文子串，比较容易想到的就是中心扩散法
        :type s: str
        :rtype: str
        """
        if len(s) == 0:
            return ''

        # 至少就是 1
        longest_palindrome = 1

        longest_palindrome_str = s[0]

        for i in range(len(s)):
            palindrome_odd, odd_len = self.__centerSpread(s, len(s), i, i)
            palindrome_even, even_len = self.__centerSpread(s, len(s), i, i + 1)

            # 当前找到的最长回文子串
            cur_max_sub = palindrome_odd if odd_len >= even_len else palindrome_even
            if len(cur_max_sub) > longest_palindrome:
                longest_palindrome = len(cur_max_sub)
                longest_palindrome_str = cur_max_sub

        return longest_palindrome_str

    def __centerSpread(self, s, len, left, right):
        """
        left = right 的时候，表示回文中心是一条线，回文串的长度是奇数
        right = left + 1 的时候，表示回文中心是任意一个字符，回文串的长度是偶数
        :param s:
        :param len:
        :param left:
        :param right:
        :return:
        """
        l = left
        r = right

        while l >= 0 and r < len and s[l] == s[r]:
            l -= 1
            r += 1
        return s[l + 1:r], r - l - 1


if __name__ == '__main__':
    solution = Solution()
    longestPalindrome = solution.longestPalindrome("babad")
    print(longestPalindrome)
