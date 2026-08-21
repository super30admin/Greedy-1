# Problem3: Candy (https://leetcode.com/problems/candy/)
#TC: O(n) because we make a single pass through the ratings array, all other work per step is O(1)
#SC: O(1) because we only use a fixed number of scalar variables, no extra arrays used
# Approach:
# We track slope changes (up, down, flat) instead of assigning candy child by child.
# Whenever an uphill run followed by a downhill run finishes (a full hill/valley), we settle its candy cost at once using the triangular number formula. 
# The peak of each hill gets extra candy equal to the longer of its two sides. 
# The first child and any flat-rating children are handled separately since the loop never directly processes index 0.

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)          # total number of children
        candies = 0                # running total of candies given so far
        up = 0                     # length of current increasing (uphill) run
        down = 0                   # length of current decreasing (downhill) run
        old_slope = 0               # slope before the current comparison, starts flat
        new_slope = 0                # slope of the current comparison, initialized to flat

        for i in range(1, n):        # start from index 1, always comparing to the previous child
            if ratings[i] < ratings[i-1]:
                new_slope = -1        # rating dropped compared to previous child, going downhill
            elif ratings[i] > ratings[i-1]:
                new_slope = 1          # rating increased compared to previous child, going uphill
            else:
                new_slope = 0           # rating same as previous child, flat

            # detect if a hill (uphill then downhill) or a plain climb just finished
            if (old_slope < 0 and new_slope >= 0) or (old_slope > 0 and new_slope == 0):
                candies += self.count(up) + self.count(down) + max(up, down)
                # count(up) pays for the uphill run, count(down) pays for the downhill run,
                # max(up,down) pays the extra candy the peak/valley child needs to beat both sides
                up = 0                  # reset uphill counter, starting fresh for next run
                down = 0                 # reset downhill counter, starting fresh for next run
            
            if new_slope == 1:
                up += 1                   # extend the current uphill run by one step
            elif new_slope == -1:
                down += 1                  # extend the current downhill run by one step
            else:
                candies += 1                # flat child just needs its baseline 1 candy right now
            
            old_slope = new_slope            # save current slope so next iteration can compare against it

        # after the loop, one last run is always left unsettled since no further transition occurred
        candies += self.count(up) + self.count(down) + max(up, down)
        return candies + 1              # +1 accounts for child at index 0, which the loop never processes
    
    def count(self, n):
        return n * (n+1) // 2        # triangular number formula, sum of 1 to n candies for a run
        
        
        
        