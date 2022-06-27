class Solution:
    def jump(self, nums: List[int]) -> int:
        if(len(nums)<2):
            return 0
        queue = [0]
        visited = set()
        ans = 1
        while(len(queue)!=0):
            for i in range((len(queue))):
                curr = queue.pop(0)
                for i in range(nums[curr]):
                    if(curr+i+1 not in visited):
                        if(curr+i+1== len(nums)-1):
                            return ans
                        visited.add(curr+i+1)
                        queue.append(curr+i+1)
                
            ans+=1
        return ans