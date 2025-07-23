"""
Use greedy BFS-like scan: track current_end (jump boundary) and farthest
Every time we reach current_end, make a jump and update current_end = farthest
Count how many such jumps are needed to reach or exceed the last index
"""
"""
Time Complexity - O(n) Single pass through the array
Space Complexity - O(1)	No extra space
"""
class jumpGame2:
    def jump(self, nums: list[int]) -> int:
        jumps = 0
        current_end = 0
        farthest = 0

        for i in range(len(nums) - 1):
            farthest = max(farthest, i + nums[i])
            if i == current_end:
                jumps += 1
                current_end = farthest

        return jumps
    
if __name__ == "__main__":
    obj = jumpGame2()
    print(obj.jump([2, 3, 1, 1, 4]))
    print(obj.jump([2, 3, 0, 1, 4]))
    print(obj.jump([1, 2]))
    print(obj.jump([1, 2, 3]))
