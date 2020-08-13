// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes. missed the edge case input [0]
//Idea is top iterate from last and find the target index. first set array lenght as target and keep iterating in reverse order that we can find the target. if target can be reachable then change the current index as target. finally if your targteIndex  is zero then return true


class Solution {
    func canJump(_ nums: [Int]) -> Bool {
        //base
        if nums.count < 2 { //missed this
            return true
        }
        var targetIndex = nums.count-1
        for i in (0..<nums.count-1).reversed() {
            //can reach target index
            if nums[i] >= targetIndex - i {
                targetIndex = i
            }
        }
        return targetIndex == 0
    }
}