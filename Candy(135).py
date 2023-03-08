class Solution:
    def candy(self, ratings: List[int]) -> int:
        # Approach 2:
        # T.C. = O(n)
        # S.C. = O(n)
        # Here we implement a 2-pass solution
        # in the first pass take care that the candies are assigned based
        # on the ratings from the left side elements
        # in the second pass we check that condition is also satified for the elements on right
        if ((ratings is None) or (len(ratings)==0)):
            return 0

        size = len(ratings)
        candies = [1 for i in range(size)]

        for i in range(1,size):
            if ratings[i]>ratings[i-1]:
                candies[i] = candies[i-1]+1
                # Redundant Since the array is filled with ones
            # else:
            #     candies[i] = 1

        ans = candies[-1] # since we would skip this element in the 2nd iteration
        for i in reversed(range(size-1)):
            if ratings[i]>ratings[i+1]:
                candies[i] = max(candies[i],candies[i+1]+1)
            # We record the candies so that we don't have to iterate again for the sum
            ans += candies[i]

        # return sum(candies)
        return ans


        # Approach 0(Why it wouldn't work): check both sides of the element and assign candies based on them
        # The problem here is that if the ratings are in descending order then we would need to
        # change the rating of each prev element as we go on encountering them
        # e.g. 5-4-3-2-1
        # here if we assign 2 candies to index 0, then when we reach idx2 we would have 0

        # Approach 1 (Working on Solution, Failing for [1,2,5,5,5,2,1]):
        # Here the middle 5 should have 1 candy but as per this implementation
        # it is giving 3 candies
        # T.C. = O(nlogn)
        # S.C. = O(n)
        # Here we store the ratings of all elements with their index
        # and sort the array based on the ratings
        # Then we go to each index and check their rating
        # if ((ratings is None) or (len(ratings)==0)):
        #     return 0

        # size = len(ratings)
        # candies = [0 for _ in range(size)]
        # ids = list()
        # for i in range(size):
        #     ids.append((ratings[i],i))
        # ids.sort()

        # for elem in ids:
        #     rating = elem[0]
        #     idx = elem[1]
        #     # if it is the first element, then we only need to compare with the next element
        #     if idx==0:
        #         if rating > ratings[idx+1]:
        #             candies[idx] = candies[idx+1] + 1
        #         else:
        #             candies[idx] = 1
        #     # if it is the last element, then we only need to compare with the prev element
        #     elif idx==size-1:
        #         if rating > ratings[idx-1]:
        #             candies[idx] = candies[idx-1] + 1
        #         else:
        #             candies[idx] = 1
        #     else:
        #         # if the rating of current element is greater than both neighbors
        #         if rating>ratings[idx+1] and rating>ratings[idx-1]:
        #             candies[idx] = max(candies[idx-1],candies[idx+1]) + 1
        #         # if the rating of current element is less than both neighbors
        #         elif rating<ratings[idx+1] and rating<ratings[idx-1]:
        #             candies[idx] = 1
        #         # if the rating is in between the 2 neighbors
        #         else:
        #             if candies[idx+1]!=0 and candies[idx-1]!=0:
        #                 candies[idx] = min(candies[idx-1],candies[idx+1]) + 1
        #             elif candies[idx-1]==0:
        #                 candies[idx] = candies[idx+1]+1
        #             else:
        #                 candies[idx] = candies[idx-1]+1

        # return sum(candies)