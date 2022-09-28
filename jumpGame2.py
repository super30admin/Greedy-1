#time Complexity: O(n)
#space Complexity : O(1)
def jump(self, nums: List[int]) -> int:
    if not nums:
        return 0
    if len(nums) == 1:
        return 0

    jumps = 1
    currJump, nextJump = nums[0], nums[0]

    for i in range(1, len(nums)):
        nextJump = max(nums[i] + i, nextJump)
        if i == currJump and i != len(nums) - 1:
            jumps += 1
            currJump = nextJump
    return jumps