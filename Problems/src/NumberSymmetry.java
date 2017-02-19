public class NumberSymmetry {
    public static void main(String[] args) {
        int[] nums = {121, 177, 16891, 0, -494, 69, -18081};
        for(int num : nums)
            System.out.printf("%d %s rotational symmetry%n", num, hasSymmetry(num) ? "has" : "doesn't have");
    }

    public static boolean hasSymmetry(int n) {
        if(n < 0) n = -n;
        if(n == 0 || n == 1 || n == 8) return true;

        String num = String.valueOf(n);
        int start = 0, end = num.length() - 1;

        while(start <= end) {
            char startChar = num.charAt(start);
            char endChar = num.charAt(end);
            if(startChar == endChar && (startChar == '0' || startChar == '1' || startChar == '8')) {
                start++;
                end--;
            } else if((startChar == '6' && endChar == '9') || (startChar == '9' && endChar == '6')) {
                start++;
                end--;
            } else return false;
        }
        return true;
    }
}