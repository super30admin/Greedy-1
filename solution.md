# Problem 1 - Jump Game
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def canJump(self, nums: List[int]) -> bool:
              if not nums or len(nums)<2:
                  return True
              destination = len(nums)-1
              for i in range(destination-1,-1,-1):
                  if i+nums[i]>=destination:
                      destination=i
              return destination==0

# Problem 2 - Jump Game II
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def jump(self, nums: List[int]) -> int:
              jumps,scope,farthest=0,0,0
              if len(nums)==1:
                  return 0
              for i in range(len(nums)):
                  farthest=max(farthest,i+nums[i])
                  if(farthest>=len(nums)-1):
                      return jumps+1
                  if i==scope:
                      jumps+=1
                      scope=farthest
              return jumps
