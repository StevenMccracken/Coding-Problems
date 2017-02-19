public class PalindromePermutation {
	public static void main(String[] args) {}
	
	public static boolean PalindromePermutation(String s) {
		s = s.toLowerCase();
		int[] charCounts = new int[256];
		
		// Count characters
		for(int i = 0; i < s.length(); i++)  ++charCounts[i];
		
		if(s.length() % 2 == 0) { // even length
			for(int count : charCounts) {
				if(count % 2 != 0) return false;
			}
		} else { // odd length
			boolean oneCharWithCountOne = false;
			for(Integer count : charCounts) {
				if(count == 1 && oneCharWithCountOne) return false;
				else if(count == 1 && !oneCharWithCountOne) oneCharWithCountOne = true;
			}
		}
		return true;
	}
}