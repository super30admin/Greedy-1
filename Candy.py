# Time Complexity : O(n), where n is the number of children
# Space Complexity : O(n)
class Solution:
    def candy(self, ratings):
        if not ratings:
            return 0
        
        n = len(ratings)
        candies = 0
        sweetTooth = [1] * n  # Default 1

        # Left pass
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                sweetTooth[i] = sweetTooth[i - 1] + 1

        candies = sweetTooth[n - 1]

        # Right pass
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                sweetTooth[i] = max(sweetTooth[i + 1] + 1, sweetTooth[i])
            candies += sweetTooth[i]

        return candies

# Examples
sol = Solution()

# Example 1
ratings1 = [1, 0, 2]
print("Ratings:", ratings1)
print("Minimum candies required:", sol.candy(ratings1))  # Output: 5

# Example 2
ratings2 = [1, 2, 2]
print("Ratings:", ratings2)
print("Minimum candies required:", sol.candy(ratings2))  # Output: 4

# Example 3
ratings3 = [1, 3, 4, 5, 2]
print("Ratings:", ratings3)
print("Minimum candies required:", sol.candy(ratings3))  # Output: 11