class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # Greedy solution
        # Here we start from the 2nd last index
        # we check if we can reach the destination from there
        # if yes we move the destination to the current index and move to the previous index
        # if no we go on checking in reverse
        # at the end if the final can be reached then the destination variable should
        # be pointing to the 0th index
        # if not => that we can't reach the final destination
        # e.g. [2,3,1,1,5]
        # we start from the 3rd index : 1
        # so 3+1=4 and 4 is the final index so we update the dest to 3
        # now we are at index 2 and 2+1=3, so we update the dest to 2
        # now we are at index 1 so 1+3>=2, so we update the dest to 1
        # now we are at index 0 so 0+2>=1, so we update the dest to 0
        if len(nums)<2:
            return True

        dest = len(nums)-1

        for i in reversed(range(dest)):
            if i+nums[i]>=dest:
                dest = i

        return dest==0


        # # BFS Solution
        # T.C. = Exponential because even if we are not visiting all, we are still calling and checking
        # if (len(nums)<2):
        #     return True
        # # queue to store the points where we can jump from the current position
        # queue = list()
        # queue.append(0)
        # # to store the indices that have been visited so we don't count jumps from there again
        # visited = set()
        # end = len(nums)-1

        # while len(queue)!=0:
        #     curr = queue.pop(0)
        #     for i in range(1,nums[curr]+1):
        #         idx = curr+i
        #         if idx == end:
        #             return True
        #         elif idx not in visited:
        #             queue.append(idx)
        #             visited.add(idx)

        # return False

    # DFS Solution: TLE
    #     if (len(nums)<2):
    #         return True

    #     self.visited = set()
    #     return self.dfs(nums,0)

    # def dfs(self,nums,idx):
    #     # base case
    #     if idx == len(nums)-1:
    #         return True
    #     if idx in self.visited:
    #         return False
    #     # logic
    #     self.visited.add(idx)
    #     for i in range(1,nums[idx]+1):
    #         new_idx = idx+i
    #         if self.dfs(nums,new_idx):
    #             return True

    #     return False