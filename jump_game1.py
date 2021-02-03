class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        #O(n)
        #O(1)
        if not nums or len(nums)==1:
            return True
    #start from last step as destination,
    #1 element previous to that  is checked> if its possible to reach destination from there>ultimately reach oth index and if all lead to good jumps>True
    #optimal solution
        i=len(nums)-2
        dest=len(nums)-1
        for k in range(i,-1,-1):
            if k+nums[k]>=dest:
                dest=k
                
        if dest==0:
            return True
        return False


        """
        way 2nd>similar to jumpgame2>go from left to right
        #O(n)
        #O(1)
        if not nums or len(nums)==1:
            return True
    #start from last step as destination,
    #1 element previous to that  is checked> if its possible to reach destination from there>ultimately reach oth index and if all lead to good jumps>True
    #optimal solution
        jumps=1
        curint=nums[0]
        nextint=nums[0]
        for i in range(1,len(nums)-1):
            nextint=max(nextint,i+nums[i])
            if i==curint:
                jumps+=1
                curint=nextint
        return curint>=len(nums)-1