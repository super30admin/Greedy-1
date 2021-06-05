class Solution:
    def candy(self, ratings: List[int]) -> int:
        
        if not ratings:
            return 0
        
        
        candy_array = [1]* len(ratings)
        #left to right
        for i in range(1,len(ratings)):
            if ratings[i] > ratings[i-1]:
                candy_array[i] = candy_array[i-1]+1
       
        print(candy_array)
        #right to left
        result= candy_array[len(ratings)-1]
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i] > ratings[i+1] and candy_array[i] <= candy_array[i+1]:
                candy_array[i] = candy_array[i+1] +1
            result += candy_array[i]
       
        print(candy_array)
        return result
        
        
        
            
