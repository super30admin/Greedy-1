# result = []
# sumOfProducts = 0

# def sumOfProductofSubSets(nums):
#     global result, sumOfProducts
#     result = []
#     sumOfProducts = 0
#     helper(nums, 0, [])
#     return sumOfProducts

# def helper(nums, pivot, path):
#     global result, sumOfProducts
#     result.append(list(path))

#     if path:
#         product = 1
#         for num in path:
#             product *= num
#         sumOfProducts += product

#     for i in range(pivot, len(nums)):
#         path.append(nums[i])
#         helper(nums, i + 1, path)
#         path.pop()

# arr = [1, 2, 3]
# print(sumOfProductofSubSets(arr))  # 23


def sumOfProductofSubSets(arr):
    n = len(arr)
    result = 1

    for i in range(n):
        result *= 1 + arr[i]

    return result - 1

arr = [1, 2, 3]
print(sumOfProductofSubSets(arr))  # 23
