class Solution:
    def canJump(self, nums: List[int]) -> bool:
        #Method 1 - BFS - TC - O(K^n) - TLE

        #Do BFS and take for loop at each element and check if you reach last index, if yes return true else add it to the q.
        # if len(nums)<2: return True
        # q=deque()
        # q.append(0)
        # while q:
        #     curr=q.popleft()
        #     if curr ==len(nums)-1: #edge case
        #         return True
        #     for i in range(1,nums[curr]+1):
        #         newidx = curr + i
        #         if newidx>=len(nums)-1:
        #             return True
        #         q.append(newidx)
        # return False

        #Method 2 - BFS with hashset - TC - O(K^n) - Successful but TC is still bad
        # if len(nums)<2: return True
        # q=deque()
        # q.append(0)
        # s=set()
        # s.add(0)
        # while q:
        #     curr=q.popleft()
        #     for i in range(1,nums[curr]+1):
        #         newidx = curr + i
        #         if newidx>=len(nums)-1:
        #             return True
        #         if newidx not in s:
        #             s.add(newidx)
        #             q.append(newidx)
        # return False

        #Method 3 - DFS - TC - O(K^n) - TLE
        # def dfs(nums,curr):
        #     #base
        #     if curr>=len(nums)-1:
        #         return True
        #     #logic
        #     for i in range(1,nums[curr]+1):
        #         newidx=curr+i
        #         if dfs(nums,newidx): return True
        #     return False

        # return dfs(nums,0)

        #DFS can't be optimized using set cause of how DFS iterates. It can be optimized in a complex manner, I didn't understand it completely.

        #Method 4 - Greedy from nth element - TC O(n) - This isn't an intuitve way of solving it.
        
        # Here, instead of doig greedy from front, we do it from n-1th position.
        #See if curr+i >=target (intially,last element), if yes update target to i and so on. In the end see if you target reaches 0th element.
        n=len(nums)
        target=n-1
        for i in reversed(range(n-1)):
            print(i)
            if nums[i]+i>=target:
                target=i
        return target==0

        

       
       


        