# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)  # Get the number of children
        upCount = downCount = peakCount = 0
        totalCandies = 1  # Initialize variables
        
        for i in range(1, n):
            if ratings[i - 1] < ratings[i]:
                # If the current child has a higher rating than the previous one
                downCount = 0
                upCount += 1
                peakCount = upCount + 1
                totalCandies += peakCount
            elif ratings[i - 1] == ratings[i]:
                # If the current child has the same rating as the previous one
                downCount = 0
                upCount = 0
                peakCount = 0
                totalCandies += 1
            else:
                # If the current child has a lower rating than the previous one
                downCount += 1
                upCount = 0
                totalCandies += downCount + 1 - (1 if peakCount > downCount else 0)
        
        return totalCandies