##T(C) -- O(n)
##S(C) -- O(1)

## greedy approach
## keep a pointer at the end of array
## if our pointer is able to reach the start of our array at 0
## return True

class Solution:
    def canJump(self, nums: List[int]) -> bool:

        n = len(nums)

        curr = n -1

        for i in range(n-2, -1, -1):
            
            if nums[i] + i >= curr:
                curr = i

            print(curr)
        
        if curr:
            return False
        else:
            return True



        
