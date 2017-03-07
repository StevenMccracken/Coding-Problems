public class ReconstructOriginalDigits {
    public static void main(String[] args) {
        String input = "owoztneoer";
        System.out.println(originalDigits(input));
    }

    public static String originalDigits(String s) {
        // zero, one, two, three, four, five, six, seven, eight, nine
        int[] digits = new int[10];
        for(char c : s.toCharArray()) {
            switch(c) {
                case 'z': digits[0]++; break; // 0
                case 'o': digits[1]++; break; // 1, 0, 2, 4
                case 'w': digits[2]++; break; // 2
                case 'h': digits[3]++; break; // 3, 8
                case 'u': digits[4]++; break; // 4
                case 'f': digits[5]++; break; // 5, 4
                case 'x': digits[6]++; break; // 6
                case 's': digits[7]++; break; // 7, 6
                case 'g': digits[8]++; break; // 8
                case 'i': digits[9]++; break; // 9, 5, 6, 8
            }
        }

        digits[3] -= digits[8];
        digits[5] -= digits[4];
        digits[7] -= digits[6];
        digits[1] = digits[1] - digits[0] - digits[2] - digits[4];
        digits[9] = digits[9] - digits[5] - digits[6] - digits[8];

        StringBuilder str = new StringBuilder();
        for(int i = 0; i <= 9; i++) {
            for(int j = 0; j < digits[i]; j++)
                str.append(i);
        }
        return str.toString();
    }
}