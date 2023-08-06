#TIme complexity is O(n)
#Space omplexity is: O(1)
#Code ran successfully on leetcode
#No issues faced while coding
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #Base codnition
        if(len(nums)<2):
            return 0
        #Initializing the required variables
        nextInt=nums[0]
        currInt=nums[0]
        jumps=1
        #Iterating through the nums array
        for i in range(1,len(nums)-1):
            nextInt=max(nextInt,i+nums[i])
            #If i reaches currInt, we update currInt value
            if(i==currInt):
                currInt=nextInt
                #incrementing jumps
                jumps+=1
        #Finally we are returning jumps
        return jumps