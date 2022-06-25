class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings or len(ratings)==0:
            return 0
        output=[1 for i in range(len(ratings))]
        output2=[1 for i in range(len(ratings))]
        for i in range(1,len(output)):
            if ratings[i]>ratings[i-1]:
                output[i]=output[i-1] + 1
                
        for i in range(len(output)-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                output[i]= max(output[i], output[i+1] + 1)
                
        return sum(output)