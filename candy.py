from typing import List


class Solution:
    def candy(self, rat: List[int]) -> int:
        n = len(rat)
        output = [1 for i in range(n)]

        for i in range(1, n):
            if rat[i] > rat[i-1]:
                output[i] = output[i-1] + 1
        
        s = output[n-1]
        
        for i in range(n-2, -1, -1):
            if rat[i] > rat[i+1]:
                output[i] = max(output[i], output[i+1] + 1)
            s += output[i]
        return s




