import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class problem2 {


    //BFS
    // Time Complexity: O(n^2)
    //Space Complexity:O(n)
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int level=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!q.isEmpty()) {
            int size= q.size();
            for (int i = 0; i < size; i++) {
                int curIdx = q.poll();
                for (int k=0;k<=nums[curIdx];k++)
                {
                    int newIdx= curIdx+k;
                    if(newIdx>=n-1)
                    {
                        return level+1;
                    }
                    if (!visited.contains(newIdx)) {
                        visited.add(newIdx);
                    }
                    if (!q.contains(newIdx)) {
                        q.add(newIdx);
                    }
                }

            }
            level++;
        }
        return 34;
    }

    //DFS
    // Time Complexity: O(n)
    //Space Complexity:O(n)
    int minJumps=0;
    HashMap<Integer, Integer> memoMap;
    public int jump1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        this.minJumps=Integer.MAX_VALUE;
      return   dfs(nums,0);
        //return minJumps;
    }
    public int dfs(int[] nums,int curIdx)
    {
        //base case
        if (curIdx >= nums.length-1)
        {
           // minJumps=Math.min(minJumps,jumps);
            return 0;
        }
        if(memoMap.containsKey(curIdx))
        {
            return memoMap.get(curIdx);
        }
        int min=99999;
        //logic
        for (int k=1;k<=nums[curIdx];k++)
        {
            int newIdx= curIdx+k;
            min= Math.min(min, dfs(nums,newIdx)+1);
            dfs(nums,newIdx);
        }
        memoMap.put(curIdx, min);
        return min;
    }

    //Tabulation
    // Time Complexity: O(n)
    //Space Complexity:O(1)

    public int jump2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int currIdx=nums[0];
        int nextIdx=   nums[0];
        int jumps=1;
        for (int i=1;i<n;i++)
        {
            nextIdx= Math.min(nextIdx,nums[i]+i);
            if (i!=n-1 && i==currIdx)
            {
                currIdx=nextIdx;
                jumps++;
            }

        }
        return jumps;
    }
}
