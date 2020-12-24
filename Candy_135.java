//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.Arrays;

class Candy_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int sum=0;
        for(int i = 1; i < n; i++)
        {
            if(ratings[i] > ratings[i-1])
                result[i] = result[i-1] + 1;
        }
        for(int j = n-2; j >= 0; j--)
        {
            if(ratings[j] > ratings[j+1])
                result[j] = Math.max(result[j], result[j+1] + 1);
        }
        for(int i : result)
            sum += i;
        return sum;
    }
}