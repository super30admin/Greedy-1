// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this problem we have see if we can reach the last element from the first element.we do this problem starting from end to start.we take the last element as destination i.e the element to be reached from a given index and we consider the element at index to be the start and check if element at the index can be reached to the destination or not.If yes we make the index as destination and move to the next previous element.In this manner we see if destination reaches -1 it means that there is a path from start element to the end element.


# Time complexity --> o(n)
# space complexity --> o(1)
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if nums==None or len(nums)<2:
            return True
        n=len(nums)-1
        dest=n
        #we are solving this problem from right to left as at every index we are seeing whther we can reach the destination or not
        for i in range(n-1,-1,-1):
            # print(dest,i)
            #compare the index+value at that index with the destination to see if we can reach the destination or not.If Yes then destination is moved to the current value indicating that destination can be reached so if the dest reaches a value less than 0 then we say that there is a path to reach from start to the end.
            if nums[i]+i>=dest:
                dest=i
        # print(dest)
        if dest<=0:
            return True
        return False
                
                
        