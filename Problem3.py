class Solution(object):
    def candy(self, ratings):
        """
        2-pass solution
        Distribute candies to children based on their ratings.
        Time complexity: O(2n) == O(n)
        Space complexity: O(n)

        :type ratings: List[int]
        :rtype: int
        """
        candy = [1] * \
            len(ratings)  # Initialize a list 'candy' with each element initialized to 1.

        # Loop through the ratings list starting from the second element.
        for i in range(1, len(ratings)):
            # If the current child's rating is higher than the previous child.
            if ratings[i] > ratings[i - 1]:
                # Give the current child one more candy than the previous child.
                candy[i] = candy[i - 1] + 1

        # Loop through the ratings list in reverse order starting from the second-to-last element.
        for i in range(len(ratings) - 2, -1, -1):
            # If the current child's rating is higher than the next child.
            if ratings[i] > ratings[i + 1]:
                # Update the current child's candy count if needed.
                candy[i] = max(candy[i], candy[i + 1] + 1)

        return sum(candy)  # Return the total number of candies distributed.
