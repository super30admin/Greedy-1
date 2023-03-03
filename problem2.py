class Solution:
    def jump(self, nums: List[int]) -> int:
        ln = len(nums)
        if ln == 0 or ln == 1 or nums[0] == 0:
            return 0 
        c = 0 
        ma = 0 
        j=0
        for i in range(ln-1):
            ma=max(ma,i+nums[i])
            if i==c:
                j+=1
                c=ma
            if c>=ln-1:
                break
        return j
        