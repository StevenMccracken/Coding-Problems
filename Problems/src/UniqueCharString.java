import java.util.Scanner;

public class UniqueCharString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("Enter a string (or 'quit'): ");
			String str = in.nextLine();
			
			if(str.equals("quit")) break;
			System.out.printf("'%s' %s unique.%n", str, (uniqueCharsInString(str) ? "is" : "isn't"));
		}
		in.close();
	}
	
	// O(n) time, O(1) space
	public static boolean uniqueCharsInString(String str)
	{
		// There will be a character repeated in the ASCII code if the string is longer than this
		if(str.length() > 256) return false;
		
		// Checker uses the bits of itself to keep track of which characters have been seen
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			// Get the ASCII value of the ith character in the string
	        int val = str.charAt(i) - 'a';
	        
	        /* Bit shift the value 1 "val" times. This will represent val in binary (1-based, not 0-based. a = 01, b = 10, c = 11, etc)
	         Anding this value with checker will be greater than 0 if the character in the string has been encountered before
	         If checker is 0011, that means characters a & b have been encountered in the string before. If val is 1, aka 'b', shifting
	         1 left 1 times will result in 0010, or 2. Anding this with checker will result in 0010, which means b showed up again. Return false.
	         */
	        if ((checker & (1 << val)) > 0) return false;
	        
	        // Add the character to checker
	        checker |= (1 << val);
	    }
	    return true;
	}
}