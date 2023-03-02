# Time Complexity :
# O (N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We do 2 passes over the ratings array. First, we initialize a result array with all 1s
#First, a pass from left to right. If the new element is greater than previous element, increase the current element to previous element + 1
#In the pass from right to left, if the new element is greater than prev, then we update result at that current element to maximum of previous element + 1 and existing value
#In the end we return the sum of the result array

class Solution:
    def candy(self, ratings: List[int]) -> int:
        result =[1] * len(ratings)
        n = len(ratings)
        prev = ratings[0]

        for i,rating in enumerate(ratings[1:]):
            if rating > prev :
                result[i+1] = result[i] +1

            prev = rating

        prev = ratings[-1]
        for i in reversed(range(0,n-1)):
            rating = ratings[i]
            if rating > prev :
                result[i] = max(result[i+1]+1,result[i])
            prev = ratings[i]

        return sum(result)
