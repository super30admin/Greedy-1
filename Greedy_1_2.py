class Solution:
    def jump(self, arr: List[int]) -> int:
        jumps = 0
        cr = 0                     #Current Range
        nr = 0                     #Next Range
        i = 0
        while i <= cr:
            if i == len(arr)-1:
                return jumps
            nr = max(nr, arr[i] + i)
            if i == cr:
                jumps += 1
                cr = nr
            i += 1
        return -1

%TC:O(n)
%SC:O(1)