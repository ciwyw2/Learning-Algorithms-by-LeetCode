class Solution:
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """

        if n <= 0:
            return False
        # 得到一个数的每个数位
        s = set()
        while True:
            square_sum = 0
            while n != 0:
                mod = n % 10
                square_sum += mod ** 2
                n = n // 10

            if square_sum == 1:
                return True

            if s.__contains__(square_sum):
                return False
            else:
                s.add(square_sum)
                n = square_sum


if __name__ == '__main__':
    n = 19
    s = Solution()

    result = s.isHappy(n)
    print(result)
