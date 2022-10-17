class Solution:
    def jump(self, nums: List[int]) -> int:
        
        ######## DFS DP Soln ##########
        
        
#         ######## DP O(n) time and O(n) space ##########
#         dp = [0 for _ in range(len(nums))]
#         dp[0] = nums[0]
        
#         # Store the furthest no. of indices or the max number of steps that can be taken from current index. Note that these are max steps and not jumps, so if nums[i] = 0 for some i, dp[i] could still have a value
#         # Eg: nums = [1,2,0,0]
#         # Then dp = [1,max(1-1,2)=2,max(2-1,0)=1,max(1-1,0) = 0] = [1,2,1,0]
#         # At index  though jumps at nums[2] = 0, we could stil have a step left (which is a step from the jump we take at index 2) that we have to carry out. If the dp array value at any index other than the destination is 0, then we can't reach the end.
        
#         for i in range(1,len(nums)):
#             dp[i] = max(nums[i],dp[i-1]-1) 
#         print(dp)
        
#         ans = 0
#         idx = 0
#         while(idx < len(nums)-1):
#         ### Move the index to idx + value in the dp table. We are guarenteed that at index idx+dp[idx] we will have max number of steps from that location irrespective of its original value in nums. This way we always take the minimum no.of steps
#             idx += dp[idx]
#             ans += 1 # Update ans
#         return ans
    
     ######## DP O(n) time and O(1) space ##########
        if len(nums) < 2:
            return 0
        
        dp = 0
        ans = 0
        flag_end = False
        # Same as above but with optimized space
        # jump_idx is used to identify which index of DP we are jumping to that is in our optimal path
        jump_idx = nums[0]
        i = 0
        while(i < len(nums)):
            dp = max(nums[i],dp-1)
            if i == jump_idx:
                # If current i is same as jump_idx increment ans and increment jump_idx with current dp value
                jump_idx += dp
                ans += 1
                if i == len(nums)-1:
                    flag_end = True # If current i is last index raise a flag
            i += 1
        if i <= jump_idx and not flag_end:
            # When we finish the loop, if jump_idx is greater than i and flag was not raised, it means that the last step we took took our jimp_idx index beyond the length of the array and even if we are reaching the end we are not adding that step to ans.
            # So we increment ans here.
            jump_idx += dp
            ans += 1
        return ans