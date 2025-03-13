//Time complexity : O(N)
//Space complexity : O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int cnt = 0;
        int sum = 0;
        for(int i = 0; i<nums1.length; i++){
            sum = sum + nums1[i];
            cnt++;
        }
        for(int i = 0; i<nums2.length; i++){
            sum = sum + nums2[i];
            cnt++;
        }
        return sum/cnt;

    }
}