public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     */
    public static int maxSubArray(int[] nums) {
        int curr = nums[0], sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            curr = Math.max(curr, sum);
            sum = Math.max(sum, 0);
        }
        return curr;
    }
}