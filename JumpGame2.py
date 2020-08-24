class Solution:
    def jump(self, nums):
        if len(nums) < 2:
            return 0 
        jump = 1 
        currInt = nums[0]
        nextInt = nums[0]
        for i in range(1,len(nums)):
            if nums[i] + i > nextInt:
                nextInt = nums[i] + i 
     
            if i < len(nums)-1 and i == currInt:
                currInt = nextInt 
                jump += 1
            
        return jump

if __name__ == "__main__":
    s = Solution()
    
    # Test case 1 
    print(s.jump([2, 3, 1, 1, 4]))
