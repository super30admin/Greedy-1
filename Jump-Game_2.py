// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
This problem can be solved using BFS approach but we are optiising the approach without using queue in here.Instead we are using scope to maintain the level of the tree and farthest to maintain the maximum length an element can jump.we maintain this farthest also to make sure scope is being placed at the end of level during traversal.


# Time complexity --> o(n)
# space complexity --> o(1)
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums==0 or len(nums)<2:
            return 0
        #Implementing BFS using scope variable.
        farthest=0
        scope=0
        jumps=0
        for i in range(len(nums)):
        #we start with the current element at the index and set the farthest for that element and scope being the level in BFS.
        #Here we are setting farthest to see the max length that the elment can go.
            if i+nums[i]>farthest:
                farthest=i+nums[i]
            #This edge case is when the first element is greater than the length of the given input 
            if farthest>=len(nums)-1:
                return jumps+1
            #when the index is equal to the scope which means that the level has been processed and we need to move to the next #level
            if i==scope:
                scope=farthest
                jumps=jumps+1
        return jumps
                
            
            