# Time Complexity : O(N!)
# Space COmpelxity : O(N)

class Solution:
    def jump(self, nums: List[int]) -> int:
        x = 0
        # x = len(nums) - 1
        count = 0
        while True:
            if x == 0:
                break
                
            for i in range(0, x):
                if nums[i] + i >= x:
                    x = i
                    count += 1
                    break
                else:
                    pass
        
        return count
