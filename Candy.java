// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class Candy {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
        int sum = 0;
        int n = ratings.length;
        int [] result = new int[n];
        Arrays.fill(result, 0);
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        //sortByValues(map);
        for(int i=0;i<ratings.length;i++){
            map.put(i, ratings[i]);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int idx = entry.getKey();
            System.out.println(idx);
            if(idx==0){
                result[idx] = (ratings[idx]>ratings[idx+1]) ? result[idx+1]+1:1;
                //ratings[idx]>ratings[idx+1]?result[idx]=result[idx+1]+1:result[idx]=1;
            }
            else if(idx==n-1){
                result[idx] = (ratings[idx]>ratings[idx-1]) ? result[idx-1]+1:1;
                //ratings[idx]>ratings[idx-1]?result[idx]=result[idx-1]+1:result[idx]=1;
            }
            else{
                //idx has to be compared with both sides;
                if(ratings[idx]<=ratings[idx-1] && ratings[idx]<=ratings[idx+1]){
                    result[idx] = 1;
                }
                else if(ratings[idx]>ratings[idx-1] && ratings[idx]>ratings[idx+1]){
                    result[idx] = Math.max(result[idx+1], result[idx-1]);
                }
                else if(ratings[idx]>ratings[idx-1] && ratings[idx]<=ratings[idx+1]){
                    result[idx] = result[idx-1]+1;
                }
                else{
                    result[idx] = result[idx+1]+1;
                }
            }
            sum+=result[idx];
        }
        System.out.println(Arrays.toString(result));
        // for(int i=1;i<n;i++){
        //     if(ratings[i]>ratings[i-1]){
        //         result[i] = 1+result[i-1];
        //     }
        // }
        // sum = result[n-1];
        // for(int i=n-2;i>=0;i--){
        //     if(ratings[i]>ratings[i+1]){
        //         result[i] = Math.max(result[i], 1+result[i+1]);
        //     }
        //     sum+=result[i];
        // }

        return sum;
    }
}