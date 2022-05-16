// time: o(n)
// space: o(1)
func jump(nums []int) int {
    currInt := nums[0]
    nextInt := nums[0]
    jumps := 1
    if len(nums) < 2 {return 0}
    for i := 1; i < len(nums); i++ {
        nextInt = int(math.Max(float64(nextInt), float64(i+nums[i])))
        if i == currInt && i != len(nums)-1 {
            jumps++
            currInt = nextInt
        }
    }
    return jumps
}

/*
approach: BFS
time: exponential
space: exponential
*/
// func jump(nums []int) int {
//     q := []int{0}
//     visited := map[int]struct{}{}
//     jumps := 0
//     for len(q) != 0 {
//         qSize := len(q)
//         for qSize != 0 {            
//             dq := q[0]
//             q = q[1:]
//             if dq >= len(nums)-1 {
//                 return jumps
//             }
//             // explore all the childs
//             // all childs here are the next 
//             for i := nums[dq]; i >= 1; i-- {
//                 nextIdx := i+dq
//                 if _, ok := visited[nextIdx]; ok {continue}
//                 visited[nextIdx] = struct{}{}
//                 if nextIdx >= len(nums)-1 {
//                                 return jumps+1
//                             }
//                 q = append(q, nextIdx)
//             }
//             qSize--
//         }
//         jumps++
//     }
//     return jumps
// }
