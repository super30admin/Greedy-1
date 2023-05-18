class Solution:
    def jump(self, nums: List[int]) -> int:
        #do bfs by keeping count of levels,on reaching the target return the count
        #TC-O(V+E),SC-O(V)
        if len(nums)<2:
            return 0
        visited = set()
        q = []
        count=1
        q.append(0)
        visited.add(0)
        target=len(nums)-1
        while(q!=[]):
            s = len(q)
            for i in range(s):
                curridx = q.pop(0)
                curr = nums[curridx]
                for j in range(curr,0,-1):
                    newidx = curridx+j
                    if newidx>=target:
                        return count
                    if newidx not in visited:
                        q.append(newidx)
                        visited.add(newidx)
            count+=1
        return count
