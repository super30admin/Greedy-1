'''
Time Complexity --> O(n)
Space Complexity --> O(n)
We can use a BFS approach here
'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        q = []
        level = 1
        q.append(0)
        visited = {}
        n = len(nums)
        if n==1:
            return 0
        while q:
            #print(q)
            s =len(q)
            
            #visited[index]=1
            for i in range(s):
                index = q.pop(0)
                for i in range(1,nums[index]+1):
                    new_index = i+index
                    if new_index not in visited:
                        if new_index == n-1:
                            return level
                        visited[new_index]=1
                        q.append(new_index)
            level+=1
        return level



            
        


            # print(q,end =' ')
            # print(level,end =' ')
            # print(visited)
        #return level
        
