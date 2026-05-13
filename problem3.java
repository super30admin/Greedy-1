import java.util.*;

class Solution {

    /**
    Time Complexity : O(N)
    Explanation:
    - Left to right pass → handle increasing ratings
    - Right to left pass → handle decreasing ratings
    Each element is processed constant number of times.

    Space Complexity : O(N)
    Explanation:
    Extra array is used to store candies for each child.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried assigning candies in one pass,
    but it failed for decreasing sequences.
    Fixed it using two passes:
        1) Left → Right for increasing ratings
        2) Right → Left for decreasing ratings
    Also used Math.max() to preserve previous valid assignments.
    */

    public int candy(int[] ratings) {

        int n = ratings.length;

        int[] arr = new int[n];

        // Every child gets at least 1 candy
        Arrays.fill(arr, 1);

        // Left to right
        for (int i = 1; i < n; i++) {

            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        int total = arr[n - 1];

        // Right to left
        for (int i = n - 2; i >= 0; i--) {

            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }

            total += arr[i];
        }

        return total;
    }
}