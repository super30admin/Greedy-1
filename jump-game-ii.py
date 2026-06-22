# O(n) time, O(1) space
class Solution:
    def jump(self, nums: List[int]) -> int:
        #. 0 1 2 3 4
        # [2,3,1,1,4]
        #        i
        # res=2,curEnd=4, curFar=4
        res = 0 # total number of jumps taken so far    
        cur_end = 0 # boundary of current jump's range
        cur_far = 0 # furthest index you could reach if you chose the best possible launch pad from the current window
        for i in range(len(nums)-1): # stop before last index
            # i+nums[i] is if I were to jump from here, how far could I go?
            cur_far = max(cur_far,i+nums[i])
            if i == cur_end: # you have officially evaluated every single stepping stone available to you from your previous jump. You have no choice but to jump again.
                res+=1 # Take the jump
                cur_end=cur_far # Push your boundary out to the frontier you discovered
        
        return res

