//55. Jump Game - https://leetcode.com/problems/jump-game/description/

//Time Complexity: O(n^2) ~ Exponential
//Space Complexity: O(n) ~ Height of the tree
//Brute Force - Exhaustive Approach
//BFS - Time Limit Exceeded
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //base case
        if(n == 1) return true;

        Queue<Integer> q = new LinkedList<>();
        q.add(0); //add first index

        while(!q.isEmpty()){
            int currIdx = q.poll();
            for(int k=1; k<= nums[currIdx]; k++){ //from 1-->currIdx value
                int newIdx = currIdx+k;
                if(newIdx >= n-1) return true;
                q.add(newIdx);
            }
        }
        return false;
    }
}

//BFS + Memoization
//This avoids Time Limit Exception
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //base case
        if(n == 1) return true;

        Queue<Integer> q = new LinkedList<>();
        q.add(0); //add first index

        //HashSet to memoize the visited index
        //equivalent to visited set
        HashSet<Integer> memoSet = new HashSet<>();
        memoSet.add(0);

        while(!q.isEmpty()){
            int currIdx = q.poll();
            for(int k=1; k<= nums[currIdx]; k++){ //from 1-->currIdx value
                int newIdx = currIdx+k;
                if(newIdx >= n-1) return true;
                //check the index if its present in HashSet before adding it in the Queue
                if(!memoSet.contains(newIdx)){
                    q.add(newIdx); //add to both queue and set
                    memoSet.add(newIdx);
                }
            }
        }
        return false;
    }
}

//Exhaustive Approach
//DFS - Time Limit Exceeded
class Solution {
    int n;
    public boolean canJump(int[] nums) {
        this.n = nums.length;
        //base case
        if(n == 1) return true;
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int currIdx){
        //base case
        if(currIdx >= n-1) return true;

        //logic
        for(int k=1; k<=nums[currIdx]; k++){
            int newIdx = currIdx+k;
            if(dfs(nums, newIdx)){
                return true;
            }
        }

        return false;
    }
}

//DFS + Memoizing
class Solution {
    int n;
    HashSet<Integer> memoSet ;
    public boolean canJump(int[] nums) {
        this.n = nums.length;
        this.memoSet = new HashSet<>();
        //base case
        if(n == 1) return true;
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int currIdx){
        //base case
        if(currIdx >= n-1) return true;
        if(memoSet.contains(currIdx)){
            return false;
        }
        //logic
        for(int k=1; k<=nums[currIdx]; k++){
            int newIdx = currIdx+k;
            if(dfs(nums, newIdx)){
                return true;
            }
        }
        memoSet.add(currIdx);
        return false;
    }
}

//Optimal - Greedy Approach
//Bottom-Up Approach
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(nums.length < 2)
            return true;

        //last index of the array A
        int target = n-1 ;
        //from last to first index
        for(int i = n-2; i >= 0; i--)
        {
            //if ith index + vlue at that index is > or = lastIndex
            if(i + nums[i] >= target)
            {
                //initialize lastIndex with i
                target = i;
            }
        }
        //if lastIndex can be reached and is == 0; return true
        //else return false
        return target == 0;
    }
}