#time Complexity: O(n+n)
#space Complexity : O(n)
def candy(self, ratings: List[int]) -> int:
    if not ratings:
        return 0
    n = len(ratings)
    result = [1] * n

    for i in range(1, n):
        if ratings[i] > ratings[i - 1]:
            result[i] = result[i - 1] + 1
    # print(result)
    minCandy = result[-1]
    for i in range(n - 2, -1, -1):
        if ratings[i] > ratings[i + 1] and result[i] <= result[i + 1]:
            result[i] = result[i + 1] + 1
        minCandy += result[i]
    # print(result)
    return minCandy