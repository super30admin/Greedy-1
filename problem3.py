#time complexity: O(n)
#space complexity: O(n)
#Go thorugh the candies from left to right and only statisy the condition for the candies on the left. next, start from end and go till the start of array and satisfy the condition for candies to the right.
class Solution:
    def candy(self, ratings: List[int]) -> int:
        L=[1]*len(ratings)
        #check condtio for only left side in the 1st pass
        for i in range(1,len(L)):
            if(ratings[i] > ratings[i-1]):
                L[i]=L[i-1]+1
        
        for j in range(len(L)-2,-1,-1):
            if(ratings[j]>ratings[j+1]):
                L[j]=max(L[j],L[j+1]+1)
        return sum(L)
