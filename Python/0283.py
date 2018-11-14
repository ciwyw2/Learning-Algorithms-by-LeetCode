class Solution:

    # 快速排序的方法，最简单，最直接

    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        # [0,not_zero_end） 保持都非 0，
        # [not_zero_end,len-1] 为 0
        not_zero_end = 0

        for i in range(len(nums)):
            if nums[i] != 0:
                self.__swap(nums, not_zero_end, i)
                not_zero_end += 1

    def __swap(self, nums, index1, index2):
        if index1 == index2:
            return
        temp = nums[index1]
        nums[index1] = nums[index2]
        nums[index2] = temp


if __name__ == "__main__":
    s = Solution()
    nums = [0, 1, 0, 3, 12]
    s.moveZeroes(nums)
    print(nums)
