#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: yes
#Greedy approach is to calculate the maximum index that can be reached from every index.
class Solution:
    def jump(self, nums: List[int]) -> int:
        if(len(nums)==1):
            return 0
        current=nums[0]+0
        next=1
        steps=1
        for i in range(1,len(nums)):
            next=max(nums[i]+i,next)
            if(i==current and current<len(nums)-1):
                steps+=1
                current=next
        return steps


