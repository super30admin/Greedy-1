class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # usign greedy approach to keep track of the farthest index it can jump at every step
        # and once we reach end of the current jumps ranhge we increase our count by 1, until we reach the end of the List
        # tc. : O(n), sc : O(1)

        jumps = 0
        n = len(nums)
        curr_end , max_curr_far = 0 , 0

        for i in range(n-1): # as with before steps we need to reach end , we shouldn't take last index into count
            max_curr_far = max(max_curr_far, i+nums[i]) # the farthest index is either existing one or the new possibility i.e i+nums[i] steps from this index

            if i == curr_end: # reached the farther index tghen we should increase our jump count
                jumps+=1
                curr_end = max_curr_far

        return jumps

                

