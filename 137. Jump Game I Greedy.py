class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        destination = n - 1
        # we start from the back of the nums array if the current index can reach the
        # destination then the if the current index can reach the destination
        # we'll update the current index = destination
        for i in range(n - 2, -1, -1):
            if i + nums[i] >= destination:
                destination = i
        # in the end if the destination == 0. i.e if it has reach 1st index
        return destination == 0

# Greedy
# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

if __name__ == "__main__":
    obj = Solution()
    obj.canJump()
