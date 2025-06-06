'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        destIdx = n-1

        for i in range(n-1, -1, -1):
            if destIdx - i <= nums[i]:
                destIdx = i

        if destIdx == 0:
            return True
        
        return False