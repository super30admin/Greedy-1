#time- O(n)
#space-O(1)
#des- explore from the left and see the left neighbour is less than the curr value, if yes increment by 1, follow the same approach from the right

class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings)==0:
            return 0
        candy=[1]*len(ratings)
        for i in range(1,len(ratings)):
            if ratings[i-1]<ratings[i]:
                candy[i]=candy[i-1]+1
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i+1]<ratings[i]:
                candy[i]=max(candy[i],candy[i+1]+1)
        sum=0
        # print(candy)
        for i in candy:
            sum+=i
        return sum