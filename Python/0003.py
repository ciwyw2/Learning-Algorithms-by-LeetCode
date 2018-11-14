class Solution:

    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 这是最简洁的写法，代码注释请见 3_1.py

        map = dict()
        max_len = 0
        pointer = 0

        for index, c in enumerate(s):
            if c in map:
                pointer = max(pointer, map[c] + 1)
            max_len = max(max_len, index - pointer + 1)
            map[c] = index
        return max_len


if __name__ == '__main__':
    s = 'pwwkew'
    solution = Solution()
    result = solution.lengthOfLongestSubstring(s)
    print(result)
