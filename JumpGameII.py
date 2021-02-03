"""
Approach:

Lets take an example to understand the algorithm
[3 , 4 , 2 , 1 , 1 , 2 , 2 , 1]
 0   1   2   3   4   5   6   7 


Here what we basically want to do is from every index i in nums array we need to check if the taking 1 to nums[i] covers the maximum distance.

For example from 3 we can reach 4,2,1 in on 1 jump. Which should be taken.
Jump to 4: We can reach 1+4= 5th index at max
Jump to 2: We can reach 2+2= 4th index at max
Jump to 1: We can reach 1+3= 4th index at max

So out of the above 3 elements(4,2,1) we will take 4 to reach upto maximum 5th index
Our maximum interval covered right now is upto 5th index

Now we need to maintain how many jumps we have done uptill now. So lets maintain a table.

jumps       curr        maxInterval
1           3           0: 0+3 = 3 
1           3           1: 1+4 = 5
1           3           2: 2+2 = 4
1           3           3: 3+1 = 4 <- Maximum length of jump reached. Update curr to maxInterval(5) and                                       increment jumps

2           5           3: 1+3 = 4
2           5           4: 1+4 = 5 <- Maximum length of jump reached. Update curr to maxInterval(5) and                                       increment jumps

3           5           5: 2+5 = 7 <- last index reached

Max jumps needed was 3

TC: O(n)
SC: O(1)
"""

class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums == None or len(nums) < 2:
            return 0
        
        jumps = 1
        curr = nums[0]
        maxiInterval = nums[0]
        
        for i in range(1, len(nums)-1):
            print("Jums:", jumps, end=" ")
            print("currInt:", curr, end=" ")
            print("nextInt:", maxiInterval)

            maxiInterval = max(maxiInterval, i + nums[i])
            if i == curr:
                jumps += 1
                curr = maxiInterval
                
        return jumps
        