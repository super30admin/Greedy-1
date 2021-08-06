class Solution:
    def candy(self, ratings: List[int]) -> int:
        """Greedy approach
        Time complexity-O(n)
        Space complexity-O(n)"""
        arr=[1 for _ in range(len(ratings))]
        for i in range(1, len(ratings)):
            if ratings[i]>ratings[i-1]:
                arr[i]=arr[i-1]+1
        total=arr[-1]
        for i in range(len(ratings)-2, -1, -1):
            if ratings[i]>ratings[i+1]:
                arr[i]=max(arr[i+1]+1, arr[i])
            total+=arr[i]
        return total