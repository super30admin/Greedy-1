'''
TC: O(n)
SC: O(n)
'''
class Solution:
    def candy(self, r: List[int]) -> int:
        rlen = len(r)
        can = [1 for _ in r]
        
        for i in range(1, rlen):
            if r[i] > r[i - 1]:
                can[i] = can[i - 1] + 1
        
        for i in range(rlen - 2, -1, -1):
            if r[i] > r[i + 1]:
                can[i] = max(can[i], can[i + 1] + 1)
        
        return sum(can)

        
        