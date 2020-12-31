// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set reachable = 0
loop over nums
if i > reachable return false (i cannot be more than max reachable from previous elements)
reachable = max(reachable, nums[i]+i)
if we manage to get out of loop then return true
*/
package main

import "fmt"

func canJump(nums []int) bool {
	if len(nums) < 2 {
		return true
	}
	n := len(nums)
	/*
	   //greedy start from last check if we can reach or cross dest from indices before it
	   // if so then reduce dest, if dest reaches 0 then we can go from start to last

	   dest := n - 1
	   for i := n -2; i >=0;i-- {
	       if nums[i] + i >= dest {
	           dest = i
	       }
	   }
	   if dest == 0 {
	       return true
	   } else {
	       return false
	   } */
	//greedy start at beginning, check at each index if we are able to touch reachable, if i > reachable then it means max reachable is less than i so its unreachable with max at each location
	reachable := 0
	for i := 0; i < n; i++ {
		if i > reachable {
			return false
		}
		reachable = max(reachable, nums[i]+i)
	}
	return true
	//return dfs(nums, 0)
}

func dfs(nums []int, ind int) bool {
	//base
	if ind == len(nums)-1 {
		return true
	}
	//logic //if entry is 0 then return false as not possible to move forward
	for i := 1; i <= nums[ind]; i++ {
		if dfs(nums, ind+i) {
			return true
		}
	}
	return false
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func MainCanJump() {
	fmt.Println(canJump([]int{3, 2, 1, 0, 4})) //false
}
