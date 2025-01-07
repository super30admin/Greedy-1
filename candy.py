# // Time Complexity :O(n) for 2 pass
# // Space Complexity :O(n) for Array/O(1) for Greedy
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Slope logic comparison 


# // Your code here along with comments explaining your approach
# 2pass logic: T: O(n) S: O(n) 
class Solution:
    def candy(self, ratings: list[int]) -> int:
        n = len(ratings)
        resArr = [1] * n
        for i in range(1,n):                            # left to right 
            if ratings[i] > ratings[i-1]:
                resArr[i] = resArr[i-1]+1


        for i in range(n-2,-1,-1):                      # right to left 
            if ratings[i] > ratings[i+1]:
                resArr[i] = max(resArr[i], resArr[i+1]+1) 


        return sum(resArr)                             


        

# 1 pass slope logic T: O(n) S: O(1) 
class Solution:
    def candy(self, ratings: list[int]) -> int:
        n = len(ratings)
        up = 0
        down = 0

        oldSlope = 0
        newSlope = 0
        candies = 0

        def count(n):
            return (n*(n+1))//2

        for i in range(1,n):    
            newSlope = -1 if ratings[i] < ratings[i-1] else (1 if ratings[i] > ratings[i-1] else 0)     # find new slope
            
            if (oldSlope > 0 and newSlope == 0 ) or (oldSlope < 0 and newSlope >= 0):                   # compare slope; if unque case reset upDown
                candies += count(up) + count(down) + max(up,down)
                up, down = 0,0


            if newSlope == 1:                                                                           # set slopes
                up+=1
            if newSlope == -1:
                down+=1
            if newSlope == 0:
                candies+=1
            
            oldSlope = newSlope                                                                         # reset slopes
        
        candies += count(up) + count(down) + max(up,down)                                               # final count 

        return candies+1                                                                                # +1 for index 0

