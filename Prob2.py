class Solution:
    def jump(self, nums: List[int]) -> int:

        #Method 1 - BFS + set - Same as Jump 1 - O(k^n) - still slow TC
        # if len(nums)<2: return 0 
        # s=set()
        # q=deque()
        # q.append(0)
        # s.add(0)
        # jumps=1 #set it to 1 and not 0 because of the way the jumps variable is getting updated is after we finish the current level in the graph, but you can reach the target in the middle of the level too.
        # while q:
        #     size=len(q)
        #     for i in range(size):
        #         curr=q.popleft()
        #         for j in range(1,nums[curr]+1):
        #             newidx=curr+j
        #             if newidx>=len(nums)-1:
        #                 return jumps
        #             if newidx not in s:
        #                 s.add(newidx)
        #                 q.append(newidx)
        #     jumps+=1
        # return jumps
        #Method 2 - Greedy - Be greedy with the next interval -  logic is that, the more number of options I can cover in the next interval, the closer I am to the target with lesser jumps and also have more options.
        #TC - O(n) and SC O(1)
        if len(nums)<2: return 0
        currinterval=nums[0]
        nextinterval=nums[0]
        jumps=1
        n=len(nums)
        for i in range(1,n):
            nextinterval=max(nextinterval,i+nums[i])
            if i!=n-1 and i==currinterval:
                currinterval=nextinterval
                jumps+=1
        return jumps
