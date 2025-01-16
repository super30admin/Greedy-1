import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class problem1 {

    //BFS
    //Time Complexity:O(k^n)
    // Space Complexity: O(n)
    public boolean canJump1(int[] nums) {
        int n=nums.length;
        if(n==1){return true;}
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        HashSet<Integer> visited=new HashSet<>();
        visited.add(0);
        while(!queue.isEmpty()){
            int curr_idx=queue.poll();
            for(int k=1;k<=nums[curr_idx];k++){

                int newIdx= curr_idx+k;
                if(newIdx>=n-1){return true;}
                if(!visited.contains(newIdx)){
                    queue.add(newIdx);
                    visited.add(newIdx);
                }
             //   queue.add(newIdx);
            }
        }
        return false;
    }
//DFS

    //Time Complexity:O(k^n)
    // Space Complexity: O(n)
    HashSet<Integer> memoSet;
    public boolean canJump2(int[] nums) {
        int n=nums.length;
        this.memoSet=new HashSet<>();
        if(n==1){return true;}
        return dfs(nums,0);
    }
    public boolean dfs(int[] nums,int idx){

        //base condition
        if(idx>=nums.length){return true;}
        if(memoSet.contains(idx)){return false;}

        //logic
        for (int k=1;k<=nums[idx];k++){
            int newIdx= idx+k;
            if(dfs(nums,newIdx)){return true;}
        }
        memoSet.add(idx);
        return false;
    }


    // approach 3
    //Time Complexity:O(n)
    // Space Complexity: O(1)
    public boolean canJump3(int[] nums) {
        int n=nums.length;
        if(n==1){return true;}
        int target= n-1;

        for (int i=n-2;i>=0;i--)
        {
            if (nums[i] +i >=target)
            {
                target=i;
            }
        }
        return target==0;
    }


}
