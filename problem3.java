// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

/*
Appraoch
we use a 2 pass methord here, first we go left to right, only check if
the num[i] > nums[i-i] if  so +1 candy is given

in the second pass we go from right to left, only checking if
j > j+1
if it is we max the between cur value of next value +1
and we add the to result

return result
*/
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        int re = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                arr[j] = Math.max(arr[j], arr[j + 1] + 1);
            }
            re += arr[j];
        }
        return re;
    }
}