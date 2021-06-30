class Solution:
    def jump(self, nums: List[int]) -> int:

        if nums is None or len(nums) == 0: return False
        myqueue = deque()
        myqueue.append(0)
        mapnode = collections.defaultdict(bool)
        mapnode[0] = True
        jumsp = 1

        while myqueue.__len__() > 0:
            size = myqueue.__len__()
            for idx in range(size):
                index = myqueue.popleft()
                if index == len(nums) - 1: return jumsp
                for nextjump in range(1, nums[index] + 1):
                    if mapnode[index + nextjump] == False:
                        if (index + nextjump) == len(nums) - 1: return jumsp
                        myqueue.append(index + nextjump)
                        mapnode[index + nextjump] = True

            jumsp += 1

        return 121123

    class Solution:
        #     def jump(self, nums: List[int]) -> int:

        #         class Solution:
        def jump(self, nums: List[int]) -> int:
            if len(nums) == 1:
                return 0
            farthest = nums[0]
            count = 0
            best_step_reach = farthest
            for i, n in enumerate(nums):
                if i > farthest:
                    farthest = best_step_reach
                    count += 1
                tmp = i + n
                if tmp > best_step_reach:
                    best_step_reach = tmp
                if best_step_reach >= len(nums) - 1:
                    if i == 0:
                        count += 1
                    else:
                        count += 2
                    break
            return count 