//Time Complexity: O(N)
//Space Complexity: O(1)

import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);
        int ans = ratings.length;

        while(true){
            boolean bool = false;
            for(int i = 0; i < ratings.length-1; i++){

                if(ratings[i] > ratings[i+1] && arr[i] <= arr[i+1]){
                    arr[i]++;
                    ans++;
                    bool = true;
                }

                if(ratings[i] < ratings[i+1] && arr[i] >= arr[i+1]){
                    arr[i+1]++;
                    ans++;
                    bool = true;
                }
            }

            if(!bool)
                break;
        }

        return ans;
    }
}
