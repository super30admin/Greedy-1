class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums==None or len(nums)<2:
            return True
        n=len(nums)
        destination=n-1
        #from second last element to 0th element
        for i in range(n-2,-1,-1):
            if nums[i]+i>=destination:
                #change the destionation
                destination=i
        #destionation has to be 0th index
        if destination==0:
            return True
        return False
        
#time is O(n)
#space is O(1)
