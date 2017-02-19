public class ReverseString {
	public static void main(String[] args) {
		String test = "Helo";
		System.out.println(reverse(test));
	}
	
	public static String reverse(String input) {
		char[] chars = input.toCharArray();
		int a = 0, b = chars.length - 1;
		while(a < b) {
			char temp = chars[a];
			chars[a] = chars[b];
			chars[b] = temp;
			a++;
			b--;
		}
		return String.copyValueOf(chars);
	}
}