#time Complexity: O(n^2)
#space Complexity : O(n)

def canJump(self, nums: List[int]) -> bool:
    if not nums:
        return False

    dp = [False] * len(nums)

    dp[-1] = True
    n = len(nums)
    for idx in range(n - 2, -1, -1):
        farthestIdx = min(nums[idx] + idx, n - 1)

        for i in range(idx + 1, farthestIdx + 1):
            if dp[i] == True:
                dp[idx] = True
                break
    return dp[0]

#time Complexity: O(n)
#space Complexity : O(1)

def canJumpGreedy(self, nums: List[int]) -> bool:
    if not nums:
        return False
    prev = len(nums) - 1
    for i in range(len(nums) - 1, -1, -1):
        if i + nums[i] >= prev:
            prev = i
    return prev == 0