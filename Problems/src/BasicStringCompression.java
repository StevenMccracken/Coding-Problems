public class BasicStringCompression {
	public static void main(String[] args) {
		System.out.println(compressStringByCounts("abbca"));
	}
	
	// O(n) time, O(n) space
	public static String compressStringByCounts(String str) {
		if(str.length() < 2) return str;
		
		int maxCount = 0, currCharCount = 1;
		StringBuffer newStr = new StringBuffer();
		char currChar = str.charAt(0);
		
		for(int i = 1; i < str.length(); i++) {
			if(currChar == str.charAt(i)) currCharCount++;
			else {
				newStr.append(String.valueOf(currChar) + currCharCount);
				currCharCount = 1;
				currChar = str.charAt(i);
			}
			if(currCharCount > maxCount) maxCount = currCharCount;
		}
		return maxCount == 1 ? str : newStr.append(String.valueOf(currChar) + currCharCount).toString();
	}
}