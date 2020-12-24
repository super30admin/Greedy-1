# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 0
        furthest, i, last_jmp_indx, jumps = 0,0,0,0
        while i < len(nums):
            furthest = max(furthest, i + nums[i])
            if last_jmp_indx == i:
                last_jmp_indx = furthest
                jumps += 1
                
                if furthest >= len(nums)-1:
                    return jumps
            i += 1
            
        return jumps