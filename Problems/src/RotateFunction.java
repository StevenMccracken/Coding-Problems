import java.util.stream.IntStream;

public class RotateFunction {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        System.out.println(maxRotateFunction(nums));
    }

    public static long maxRotateFunction(int[] A) {
        int n = A.length;

        long max = Long.MIN_VALUE;
        int start = 0;
        for(int i = 0; i < n; i++) {
            long sum = 0;
            int j = 0, k = start;

            for(; j < n; j++, k++) {
                if(k == n) k = 0;
                sum += j * A[k];
            }

            max = Math.max(sum,max);
            start++;
        }
        return max;
    }
}