import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class JumpGame2 {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int jumpGreedy(int[] nums) {
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            curFar = Math.max(curFar, i + nums[i]);

            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(n) for the set to store visited indices
    public int jumpBFS(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int n = nums.length;
        int jump = 0;
        Queue<Integer> queue = new LinkedList<>();

        Set<Integer> set = new HashSet<>();
        queue.add(0);
        set.add(0);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int curr = queue.poll();

                for(int j = 1; j <= nums[curr]; j++){
                    int newIdx = curr + j;

                    if(newIdx >= n-1){
                        return jump+1;
                    }
                    if(!set.contains(newIdx)){
                        queue.add(newIdx);
                        set.add(newIdx);
                    }
                }
            }
            jump++;
        }
        return 0;
    }


    // Time Complexity: O(n^2)
    // DFS
    public int jumpDFS(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        Map<Integer, Integer> memoMap = new HashMap<>();

        int n = nums.length;
        return dfs(nums, 0, memoMap);
    }

    private int dfs(int[] nums, int index, Map<Integer, Integer> memoMap){
        // base
        if(index >= nums.length-1){
            return 0;
        }

        if(memoMap.containsKey(index)){
            return memoMap.get(index);
        }

        // logic
        int min = 99999999;
        for(int j = 1; j <= nums[index]; j++){
            int nextInt = index + j;
            int jumps = 1 + dfs(nums, nextInt, memoMap);
            min = Math.min(min, jumps);
        }
        memoMap.put(index, min);
        return min;
    }
}