class Solution:
    def candy(self, ratings: List[int]) -> int:
        # Time, Space Complexity: O(n)
        if(ratings==None or len(ratings)==0):
            return
        o = [1]
        
        for i in range(1,len(ratings)):
            if(ratings[i]>ratings[i-1]):
                o.append(o[-1]+1)
            else:
                o.append(1)
        
        for i in range(len(ratings)-2,-1,-1):
            if(ratings[i]>ratings[i+1]):
                o[i]= max(o[i], o[i+1]+1)

        return sum(o)
