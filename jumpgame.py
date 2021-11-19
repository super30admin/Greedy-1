class Solution:
    """TC- exponential time"""
    def canJump(self, nums) -> bool:
        """This is a bfs solution"""
        if nums == None or len(nums) < 2:
            return True
        q = collections.deque()
        visitedset = set()
        q.append(0)
        visitedset.add(0)
        while len(q) > 0:
            current = q.popleft()
            if current == len(nums) - 1:
                return True
            ##else we are gonna take jumps
            ###jumps equal <= to the current number
            for k in range(1, nums[current] + 1):
                ###first we check if this is already in th queue or not
                newindex = current + k
                if newindex == len(nums) - 1:
                    return True
                if newindex not in visitedset:
                    q.append(newindex)
                    visitedset.add(newindex)
        return False




        ###we are going to add this index in the quee



