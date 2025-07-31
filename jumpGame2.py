class Solution:
    def jump(self, nums: List[int]) -> int:
        currWindow = 0
        maxWindow = 0
        n = len(nums)
        jmps = -1
        if n == 1:
            return jmps + 1
        for i in range(n):
            maxWindow = max(maxWindow, i + nums[i])
            if currWindow == i:
                jmps += 1
                currWindow = maxWindow
                if currWindow >= n - 1:
                    return jmps + 1
        return -1