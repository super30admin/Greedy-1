# Time - O(N)
# Space - O(1)
# greedy approach- asigning jumps variable, current and next variables. changing the next variable based on the max jumps we can do. if current == range index incrementing
the jump count and if current greater than equal to destination index we return the jump count which is the minimum number of paths to reach the destination.


class Solution:
    def jump(self, nums: List[int]) -> int:
        
        if not nums or len(nums)== 0 or len(nums)== 1:
            return 0
        
        jumps = 1
        curr = nums[0]
        nxt = nums[0]
        
        for i in range(1, len(nums)-1 ):
            nxt = max(nxt, nums[i]+i)
            
            if i == curr:
                jumps += 1
                curr = nxt
            
            if curr >= len(nums)-1:
                return jumps
            
        return jumps 
