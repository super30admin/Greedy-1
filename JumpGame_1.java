import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame_1 {

    //BFS Solution

    //Time complexity : O(n^2) in worst case
    //Space Complexity : O(n) in worst case
    //Did it run on leetcode : yes
    public boolean canJump(int[] nums) {

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        q.add(0); set.add(0);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == nums.length - 1) return true;
            for(int i = 1; i <= nums[curr]; i++){
                if(curr + i == nums.length -1) return true;
                if(!set.contains(curr + i)){
                    q.add(curr + i);
                    set.add(curr + i);
                }
            }
        }
        return false;
    }

    //greedy solution
    //Time complexity : O(n)
    //Space Complexity : O(1)
    //Did it run on leetcode : yes

    public boolean canJump_greedy(int[] nums) {
        int dest = nums.length -1;
        for(int i = nums.length - 2; i >=0; i--){
            if(i + nums[i] >= dest)
                dest = i;
        }
        return dest == 0;
    }
}
