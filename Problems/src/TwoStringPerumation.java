public class TwoStringPerumation {
	public static void main(String[] args) {
		String s1 = "ad";
		String s2 = "bc";
		System.out.println(TwoStringPermutation(s1,s2));
	}
	
	// O(n) time, O(n) space
	public static boolean TwoStringPermutation(String s1, String s2)
	{
		if(s1 == null || s2 == null) return false;
		if(s1.length() != s2.length()) return false;
		
		int[] count1 = new int[256];
		for(int i = 0; i < s1.length(); i++) count1[s1.charAt(i)]++;
		for(int i = 0; i < s2.length(); i++) {
			if(--count1[s2.charAt(i)] < 0) return false;
		}
		return true;
	}
	
	// O(n) time, O(1) space
	// Possibility of overflow. Needs to change if text is in unicode.
	// TODO: Doesn't work for "ad" & "bc"
	public static boolean TwoStringPermutationBest(String s1, String s2) {
		if(s1 == null || s2 == null) return false;
		if(s1.length() != s2.length()) return false;
		
		long tracker = 0;
		for(int i = 0; i < s1.length(); i++) {
			tracker = tracker + (s1.charAt(i) - 32);
			tracker = tracker - (s2.charAt(i) - 32);
		}
		
		return tracker == 0;
	}
}