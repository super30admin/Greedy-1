class Solution:
    def candy(self, ratings: List[int]) -> int:
        array = [1]*len(ratings)
        
        
        for i in range(1,len(array)):
            if ratings[i]>ratings[i-1]:
                array[i]=array[i-1]+1
        
        for i in range(len(array)-1, 0, -1):
            if ratings[i-1]>ratings[i]:
                array[i-1] = max(array[i-1], array[i]+1)
            
        return sum(array)
    
time: O(N)
Space : O(1)
