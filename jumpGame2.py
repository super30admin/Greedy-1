class Solution:
    # greedy approach
    # TC: O(n)
    # SC: O(1)
    def jump(self, nums: List[int]) -> int:
        if nums is None or len(nums)==1:
            return 0
        n = len(nums)
        curinterval,nextinterval = nums[0], nums[0]
        jumps = 1
        for i in range(n):
            nextinterval = max(nextinterval,i+nums[i])
            if i<n-1 and i == curinterval:
                jumps += 1
                curinterval = nextinterval
        return jumps
       