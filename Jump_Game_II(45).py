class Solution:
    def jump(self, nums: List[int]) -> int:
        # Approach 2:
        # T.C. = O(n)
        # S.C. = O(1)
        # here we are simulating something similar to BFS
        # here we maintain a window similar to a level
        # the window tells us how far we can go in the next iteration
        if ((nums is None) or (len(nums)==0) or (len(nums)<2) or (nums[0]==0)):
            return 0
        jumps = 0
        left = right = 0

        # Once the right hits the last or beyond, we have got out answer
        # since we already account for the jump required for the next level
        while right<len(nums)-1:
            # farthest is the point in the next window we can reach max
            farthest = 0
            for i in range(left,right+1):
                farthest = max(farthest,nums[i]+i)
            # left would be the next element to end of current window
            left = right+1
            right = farthest
            jumps+=1

        return jumps


        # # BFS Solution
        # # T.C. = Exponential because even if we are not visiting all, we are still calling and checking
        # if ((nums is None) or (len(nums)==0) or (len(nums)<2)):
        #     return 0
        # # queue to store the points where we can jump from the current position
        # queue = list()
        # queue.append(0)
        # # to store the indices that have been visited so we don't count jumps from there again
        # visited = set()
        # end = len(nums)-1
        # jumps = 0

        # while len(queue)!=0:
        #     size = len(queue)
        #     for x in range(size):
        #         curr = queue.pop(0)
        #         for i in range(1,nums[curr]+1):
        #             idx = curr+i
        #             if idx == end:
        #                 # if we encounter the final index while putting it in the queue
        #                 # implies that the next level has the final dest meaning 1 more jump is needed
        #                 return jumps+1
        #             elif idx not in visited:
        #                 queue.append(idx)
        #                 visited.add(idx)
        #     jumps+=1