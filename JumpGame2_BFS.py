class Solution:
    def jump(self, nums: List[int]) -> int:
        '''
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        # base case
        if(len(nums)==1):
            return 0
        if(nums[0]>=len(nums)-1):
            return 1
        # visited to keep a check on how many elements visited, every element is added to queue only once
        visited=0
        q = deque([0])
        # jumps is the count for minimum number of jumps
        jumps=0
        while(len(q)>0):
            size = len(q)
            for i in range(0,size):
                ind = q.popleft()
                if(len(q)>0):
                    z = max(ind,q[-1])
                else:
                    z = ind
                # add the non visited children to queue
                for j in range(z+1,ind+nums[ind]+1):
                    if(visited<j):
                        if(j+nums[j]>=len(nums)-1):
                            return jumps+2
                        q.append(j)
                        visited+=1           
            jumps+=1
        return jumps
