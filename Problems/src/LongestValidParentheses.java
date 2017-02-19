import java.util.Stack;

public class LongestValidParentheses {
	public static void main(String[] args) {
		String test = ")()())";
		System.out.println(longestValidParentheses(test));
	}
	
	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int longestSequence = 0, open = 0, close = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') { stack.push(i); ++open; }
            else {
            	if(!stack.empty() && s.charAt(stack.peek()) == '(') stack.pop();
            	else stack.push(i);
            	++close;
            }
        }
        if(stack.empty()) return s.length();
        if(open == 0 || close == 0) return 0;
        
        int begin = 0, end = s.length();
        while(!stack.empty()) {
        	begin = stack.pop();
        	if(end - begin > longestSequence) longestSequence = end - begin - 1;
        	end = begin;
        }
        if(end > longestSequence) return end;
        return longestSequence;
    }
}
