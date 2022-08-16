#45. Jump Game II
"""
Time Complexity : O(n!)
Space COmpelxity : O(n)
"""
class Solution:
    def jump(self, nums: List[int]) -> int:
        st = 0
        st = len(nums) - 1
        print(st)
        count = 0
        
        while True:
            #print(st)
            if st == 0:
                break
                
            for i in range(0, st):
                if nums[i] + i >= st:
                    st = i
                    count += 1
                    break
                else:
                    pass
        
        return count
