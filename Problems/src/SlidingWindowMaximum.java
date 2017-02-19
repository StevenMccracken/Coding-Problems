import java.util.*;

/**
 * Given an array nums, there is nums sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one position.
 * For example, given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * The max sliding window is [3,3,5,5,6,7]
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] max = maximumSlidingWindow(nums,k);
        System.out.printf(Arrays.toString(max));
    }

    public static int[] maximumSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1) return new int[0];
        if(k == 1) return nums;
        
        int[] maxNums = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int index  = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) // Ensure deque's size doesn't exceed k
                deque.poll();

            // Remove numbers smaller than nums[i] from right(nums[i-1]) to left, to make the first number in the deque the largest one in the window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offer(i);// Offer the current index to the deque's tail

            if (i >= k - 1)// Starts recording when i is big enough to make the window has k elements
                maxNums[index++] = nums[deque.peek()];
        }
        return maxNums;
    }
}