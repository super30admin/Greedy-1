# Time Complexity : O(n)
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums is None or len(nums) < 2:
            return 0

        jumps = 1
        curr=nums[0]
        next=nums[0]

        print(jumps,curr,next)

        for i in range(0,len(nums)):
            next = max(next,i+nums[i])
            print("Loop",jumps,curr,next)

            if i< len(nums)-1 and i == curr:
                jumps += 1
                curr = next

        return jumps

