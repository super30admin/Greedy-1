### TC - O(n)
### SC - O(1)

class Solution:
    def jump(self, nums: List[int]) -> int:

        n = len(nums)

        jumps = 0

        l,r = 0,0

        while(r < n-1):

            window = 0

            ## find the maximum jumps we can make within the left and right interval
            ### r+ 1 because, in the interval we want to include the last value in our 
            ## traversal
            for i in range (l, r+1):
                window = max(window, nums[i] + i)
            
            ## once we have this window, update left and right pointer

            l = r+1
            r = window
            jumps += 1

        return jumps



        


        
