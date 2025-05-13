
//TC: O(kn)
/*
class Solution {
  public int jump(int[] nums) {
      if(nums.length<2){
          return 0;
      }
      int count=0;
      Queue<Integer> q=new LinkedList<>();
      Set<Integer> set=new HashSet<>();
      q.add(0);
      set.add(0);
      int n=nums.length;
      while(!q.isEmpty()){
          int size=q.size();
          count++;
          for(int i=0;i<size;i++){
              int idx=q.poll();
              for(int j=1;j<=nums[idx];j++){
                  int newidx=j+idx;
                  if(newidx==n-1){
                      return count;
                  }
                  if(!set.contains(newidx)){
                      q.add(newidx);
                      set.add(newidx);
                  }
              }
              
          }
      }
      return -1;
  }
}
*/

/*
//DFS...with TLE
class Solution {
  
  public int jump(int[] nums) {
      if(nums.length<2){
          return 0;
      }
      return dfs(nums,0);
  }

  private int dfs(int[] nums,int idx){
      //base
      if(idx>=nums.length-1){
          return 0;
      }
      //logic
      int jumps=nums[idx];
      int min=99999;
      for(int i=1;i<=jumps;i++){
         min=Math.min(min,dfs(nums,idx+i));
      }
      return 1+min;
  }
}
*/

/*
//DFS memoisation...works
class Solution {
  
  public int jump(int[] nums) {
      if(nums.length<2){
          return 0;
      }
      Map<Integer,Integer> memo=new HashMap<>();
      return dfs(nums,0,memo);
  }

  private int dfs(int[] nums,int idx,Map<Integer,Integer> memo){
      //base
      if(idx>=nums.length-1){
          return 0;
      }
      if(memo.containsKey(idx)){
          return memo.get(idx);
      }
      //logic
      int jumps=nums[idx];
      int min=99999;
      for(int i=1;i<=jumps;i++){
         min=Math.min(min,dfs(nums,idx+i,memo));
      }
      memo.put(idx,min+1);
      return 1+min;
  }
}
*/
//TC: O(n)
//Sc: O(1)
class JumpGameII {
  
  public int jump(int[] nums) {
      if(nums.length<2){
          return 0;
      }
      int n=nums.length;
      int currint=nums[0];
      int nextint=nums[0];
      int jumps=1;
      for(int i=1;i<n;i++){
          if(currint>=n-1){
              return jumps;
          }
          nextint=Math.max(nextint,i+nums[i]);
          if(currint==i){
              currint=nextint;
              jumps++;
          }
          
      }
      return 7867;
  }
}