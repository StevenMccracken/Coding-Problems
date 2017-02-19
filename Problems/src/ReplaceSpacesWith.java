public class ReplaceSpacesWith {
	public static void main(String[] args) { 
		String origStr = "Mr John Smith    ";
		char[] str = origStr.toCharArray();
		replaceAllSpacesBetter(str, 13);
		System.out.println(str);
	}
	
	// O(n) time, O(1) space
	public static char[] replaceAllSpacesBetter(char[] str, int length)
	{
		int spaces = 0;
		for(int i = 0; i < length; i++) {
			if(str[i] == ' ') spaces++;
		}
		int trueLength = length + spaces*2;
		for(int i = length - 1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[--trueLength] = '0';
				str[--trueLength] = '2';
				str[--trueLength] = '%';
			} else {
				str[--trueLength] = str[i];
			}
		}
		return str;
	}
}