class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums)<2 :
            return 0
        #safe greedy>
        #checking all elements in cur interval jump range> find its possible value to cover max interval>making sure to take minimum steps
        #checking all posssible comnbinations> so wont fail any test case>safe greedy
        #O(n)
        #O(1)
        jumps=1
        curint=nums[0]
        nextint=nums[0]
        for i in range(1,len(nums)-1):
            nextint=max(nextint,i+nums[i])
            
            if i==curint:
                jumps+=1
                curint=nextint
                if nextint==len(nums)-1:
                    break
        return jumps