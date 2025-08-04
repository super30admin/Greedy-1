# TC: O(n)
# SC: O(1)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        inc=1
        dec=0
        prev=1
        total=1
        for i in range(1, len(ratings)):
            if ratings[i]>= ratings[i-1]:
                dec=0
                if ratings[i]==ratings[i-1]:
                    prev=1 
                else:
                    prev+=1
                
                inc=prev
                total+=prev
            
            else:
                dec+=1
                if dec==inc:
                    dec+=1
                
                total+=dec
                prev=1
        
        return total







