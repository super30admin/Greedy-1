// Time Complexity : O(n^2) as we are exploring all paths in case of DFS and same in case of BFS where we are exploring each index i.
// Space Complexity : O(n) for queue and set to track visited indices in case of BFS and in DFS approach for recursion stack.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach

class Solution {

    boolean flag;

    public boolean canJump(int[] nums) {
        
        // int n = nums.length;

        // if(n < 2) {
        //     return true;
        // }

        // Queue<Integer> queue = new LinkedList<>();
        // HashSet<Integer> set = new HashSet<>();

        // queue.add(0);
        // set.add(0);

        // while(!queue.isEmpty()) {
        //     int idx = queue.poll();

        //     for(int i = 1; i <= nums[idx]; i++) {
        //         int newIdx = idx + i;

        //         if(newIdx == n-1) {
        //             return true;
        //         }

        //         if(!set.contains(newIdx)) {
        //             queue.add(newIdx);
        //             set.add(newIdx);
        //         }
        //     }
        // }

        // return false;


        int target = nums.length - 1;
        int n = nums.length;

        for(int i = n-2; i >= 0; i--) {
            if(i + nums[i] >= target) {
                target = i;
            }
        }

        return target == 0;



        // dfs(nums, 0);
        // return flag;
    }

    private void dfs(int[] nums, int idx) {
        if(flag) {
            return;
        }

        if(idx >= nums.length - 1) {
            flag = true;
            return;
        }

        for(int j = 1; j <= nums[idx]; j++) {
            int newIdx = idx + j;

            if(newIdx < nums.length && !flag) {
                dfs(nums, newIdx);
            }
        }
    }
}



// Time Complexity : O(n) as we are using greedy approach and doing single traversal of the array.
// Space Complexity : O(1) as we are not using any auxillary space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer, Integer> dpMap;

    public int jump(int[] nums) {
        int n = nums.length;

        if(n == 1) {
            return 0;
        }

        // Queue<Integer> queue = new LinkedList<>();
        // HashSet<Integer> set = new HashSet<>();

        // queue.add(0);
        // set.add(0);

        // int jumps = 0;

        // while (!queue.isEmpty()) {
        //     int size = queue.size();

        //     for(int i = 0; i < size; i++) {
        //         int currIdx = queue.poll();

        //         for(int j = 1; j <= nums[currIdx]; j++) {
        //             int child = currIdx + j;

        //             if(child >= n-1) {
        //                 return jumps + 1;
        //             }

        //             if(!set.contains(child)) {
        //                 queue.add(child);
        //                 set.add(child);
        //             }
        //         }
        //     }
        //     jumps++;
        // }

        // return 2727;



        // this.dpMap = new HashMap<>();
        // return dfs(nums, 0);



        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];

        for(int i = 0; i < nums.length; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if(i == currInt) {
                if(i != nums.length - 1) {
                    jumps++;
                }
                currInt = nextInt;
            }
        }

        return jumps;
    }

    private int dfs(int[] nums, int idx) {
        if(idx >= nums.length - 1) {
            return 0;
        }

        if(dpMap.containsKey(idx)) {
            return dpMap.get(idx);
        }

        int min = 99999;
        for(int j = 1; j <= nums[idx]; j++) {
            int child = idx + j;
            min = Math.min(min, dfs(nums, child));
        }

        dpMap.put(idx, min+1);

        return min + 1;
    }
}



// Time Complexity : O(n) where n is length of ratings array as we are doing 2 scans of the array
// Space Complexity : O(n) as we are using result array of n length to store the candy distribution
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// We are using greedy approach to solve this problem. Here we will be going over the ratings array twice. In the first pass each child with higher rating than the
// previous ones gets one more candy than the previous child. Then in the second pass which will be from right to left we will make adjustments to ensure that 
// children with higher ratings than the next child gets more candies. In the sum we will be taking sum of all the candies stored.

class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;

        int[] result = new int[n];

        Arrays.fill(result, 1);

        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }

        int sum = result[n-1];

        for(int i = n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], result[i+1] + 1);
            }

            sum = sum + result[i];
        }        

        return sum;

    }
}


