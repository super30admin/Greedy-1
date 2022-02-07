class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums == None or len(nums) < 2: return 0
        n = len(nums)
        jumps = 1
        curr = nums[0]
        nxt = nums[0]
        for i in range(0, n):
            nxt = max(nxt, i + nums[i])
            if i < n - 1 and i == curr: 
                jumps += 1
                curr = nxt
        return jumps
    
# T.C=>O(N)
# S.C => O(1)
#approach =>basically we are just seeing the current index value and calculating how far the jump can go. we are seeing max of the nxt and the i + nums[i] value. If we are able to get nxt value. we also one nxt condition that if i is less than n - 1and i is equal to curr then we increment the jumps and set curr to nxt. at the end we return jumps. 
