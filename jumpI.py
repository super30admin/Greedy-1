'''
DFS approach can be applied here
Time Complexity --> O(n) since it can travel to all noeds
Space Complexity --> O(n) that is the stack space it will occupy
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:

        def dfs(index, nums):
            if index == len(nums)-1:
                return True
            #logic
            visited[index] = 1
            #print(visited)
            for i in range(1, nums[index]+1):
                new_ind = index+i
                if new_ind not in visited and dfs(new_ind, nums):
                    return True
            return False

                        
                        
                
            
        visited = {}
        return dfs(0, nums)

        



