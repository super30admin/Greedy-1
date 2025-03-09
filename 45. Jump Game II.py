# maximizing within intervals
#space: O(1)
# time: O(n)
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) <=1:
            return 0
        currI= nums[0]
        nextI= nums[0]
        jump=1
        for i in range(len(nums)-1):
            nextI= max(nextI, i + nums[i])
            if ( i < len(nums)-1) and i == currI:
                currI= nextI
                jump +=1
        return jump
# BFS
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return 0
        visited= set([0])
        q= [0]
        level=0
        while len(q) != 0:
            size= len(q)
            for i in range(size):
                popped= q.pop(0)
                if (popped) >= (len(nums)-1):
                    return level 
                rng= nums[popped]
                for i in range(1, rng+1):
                    
                    if (popped + i) not in visited:
                        q.append(popped + i)
                        visited.add(popped+i)
            level+=1
        return -1
        
