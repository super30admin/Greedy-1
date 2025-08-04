# TC: O(n)
# SC: O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_dist=0

        for idx, val in enumerate(nums):
            max_dist=max(max_dist, idx+val)

            if max_dist>=len(nums)-1:
                return True
            else:
                if idx==max_dist:
                    return False
        
        return False