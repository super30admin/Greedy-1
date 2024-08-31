#// Time Complexity : O(N) 
# // Space Complexity : O(N) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def candy(self, ratings: List[int]) -> int:
        result = [1] * len(ratings)
        for i in range(1,len(ratings)):
            if ratings[i] > ratings[i-1]:
                result[i] = result[i-1] + 1 
        sumi = result[len(ratings)- 1]
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                result[i] = max(result[i+1] + 1,result[i])
            sumi += result[i]
        return sumi

# Approach:
# 1. Initialize an array of size n with all elements as 1. This array will store the
# number of candies each child should get. We start with 1 because we don't know
# anything about the ratings yet.
# 2. Iterate through the ratings array from left to right. If the current rating is
# greater than the previous one, we increment the number of candies for the current
# child by 1 and assign it the value of the previous child's candies plus 1.
# 3. Now, iterate through the ratings array from right to left. If the current rating is
# greater than the next one, we update the number of candies for the current child to
#     be the maximum of the current value and the number of candies of the next child plus 1.
# 4. Finally, return the sum of all the candies in the array. This sum represents the
# minimum number of candies we need to distribute.