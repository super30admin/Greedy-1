class Solution:
    def jump(self, nums: List[int]) -> int:
        # tc O(n), sc O(1).
        maxjumps = 0
        l = r = 0

        while r < len(nums) - 1:
            farthest_can_reach = 0
            for idx in range(l, r+1):
                farthest_can_reach = max(farthest_can_reach, idx + nums[idx])
            
            l = r + 1
            r = farthest_can_reach
            maxjumps += 1
        
        return maxjumps
        