'''
Time Complexity - O(2n). We are traversing the entire array twice
Space Complexity - O(n). We are using an array to store the result.
Works on Leetcode
'''
class Solution:
    def candy(self, ratings: List[int]) -> int:
        result = [1] * len(ratings) #each child should have at least 1 candy
        for i in range(1,len(ratings)):
            #if current rating is greater than previous rating then, current result is 1+previous result
            if ratings[i] > ratings[i-1]:
                result[i]=result[i-1]+1
        for i in range(len(ratings)-2, -1, -1):
            #if current rating is greater than succeeding rating then, current result is max of current and succeeding + 1 result
            if ratings[i] > ratings[i+1]:
                result[i]=max(result[i], result[i+1]+1)
        return sum(result)
        