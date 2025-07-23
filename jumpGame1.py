"""
Track the farthest index we can reach
If at any index i, we get i > farthest, it means we are stuck — return False
If at any point farthest >= last index, return True
"""
"""
Time Complexity - O(n) Single pass through the array
Space Complexity - O(1)	No extra space
"""
class jumpGame1:
    def canJump(self, nums: list[int]) -> bool:
        farthest = 0
        for i, num in enumerate(nums):
            if i > farthest:
                return False
            farthest = max(farthest, i + num)
        return True

if __name__ == "__main__":
    obj = jumpGame1()
    print(obj.canJump([2, 3, 1, 1, 4])) 
    print(obj.canJump([3, 2, 1, 0, 4])) 
    print(obj.canJump([0]))      
    print(obj.canJump([2, 0, 0])) 
