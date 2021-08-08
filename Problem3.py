# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# assign one candy for all students
# start from left and check if pres candies count is satisfying else increment
# then start from right and check the condition else increment once again
# sum of array is the required output
class Solution:
    def candy(self, ratings: List[int]) -> int:
        
        arr = [1]*len(ratings)
        
        for i in range(1,len(ratings)):
            if ratings[i] > ratings[i-1]:
                arr[i] = arr[i-1] + 1
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i] > ratings[i+1] and arr[i] <= arr[i+1]:
                arr[i] = arr[i+1] + 1
        return sum(arr)
        