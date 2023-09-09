//Problem1 Jump Game
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//in reverse for loop, check if current index element can breach the target, if yes, that element is our new target now, in this way check if first element can breach the target at that point, if yes return true;
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0) return false;
        // Queue<Integer> q= new LinkedList<>();
        // HashSet<Integer> set=new HashSet<>();
        // q.add(0);
        // set.add(0);
        // while(!q.isEmpty()){
        //     int idx= q.poll();
        //     if(idx==nums.length-1) return true;
        //     for(int i=1;i<=nums[idx];i++){
        //         int newIdx=idx+i;
        //         if(newIdx>=nums.length-1) return true;
        //         if(!set.contains(newIdx)){
        //             q.add(newIdx);
        //             set.add(newIdx);
        //         }
                    
        //     }
        // }
        // return false;

        // return dfs(nums, 0);

        //best possible Solution
        int target=nums.length-1, n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]+i>=target){
                target=i;
            }
        }
        return target==0;
    }
    // HashMap<Integer, Boolean> map= new HashMap<>(); 
    // private boolean dfs(int[] nums, int idx){
    //     //base
    //     if(map.containsKey(idx)) return map.get(idx);
    //     if(idx>=nums.length-1) return true;
    //     //logic
    //     for(int j=1;j<=nums[idx];j++){
    //         int newIdx=idx+j;
    //         if(!map.containsKey(newIdx)){
    //             boolean re= dfs(nums, newIdx);
    //             map.put(newIdx, re);
    //         }
    //         if(map.get(newIdx)) return true;
    //     }
    //     // map.put(idx, false);
    //     return false;

    // }
}

//Problem2 Jump Game 2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//for every given element, if our current element is changing our maximum jump element, increment jump and change maxJump element. return jump.
class Solution {
    public int jump(int[] nums) {
        int jump=0;
        if(nums.length<2) return 0;
        // Queue<Integer> q= new LinkedList<>();
        // HashSet<Integer> set=new HashSet<>();
        // q.add(0);
        // set.add(0);
        // while(!q.isEmpty()){
        //     int size=q.size();
        //     for(int i=0;i<size;i++){
        //         int idx= q.poll();
        //         if(idx==nums.length-1) return jump+1;
        //         for(int j=1;j<=nums[idx];j++){
        //             int newIdx=idx+j;
        //             if(newIdx>=nums.length-1) return jump+1;
        //             if(!set.contains(newIdx)){
        //                 q.add(newIdx);
        //                 set.add(newIdx);
        //             }
        //         }
        //     }
        //     jump++;
        // }
        // return jump;

        int curInterval=nums[0];
        int nextInterval= nums[0];
        for(int i=1;i<nums.length;i++){
            nextInterval=Math.max(nextInterval, nums[i]+i);

            if(i!=nums.length-1 && i==curInterval){
                curInterval=nextInterval;
                jump++;
            }
        }
        return jump+1;
    }
}

//Problem3 Distribute Candy
// Time Complexity :O(3n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// in first for loop, check for all left elements and if left element priority is less than current element priority, increment current element priority by last element prio+1.
// do the same for right element in next for loop. then take max of the 2 priorities and add it to sum.

class Solution {
    public int candy(int[] r) {
        if(r==null || r.length==0) return 0;
        int n=r.length, sum=0;
        int res[]= new int[n];
        Arrays.fill(res,1);
        for(int i=1;i<n;i++){
            if(r[i]>r[i-1])
                res[i]=res[i-1]+1;
        }
        sum=res[n-1];
        for(int i=n-2;i>=0;i--){
            if(r[i]>r[i+1])
                res[i]=Math.max(res[i], res[i+1]+1);
            
            sum+=res[i];
        }
        return sum;
    }
}