import java.util.HashSet;
import java.util.Stack;

public class SumOfLeftLeaves {
	public static void main(String[] args) {}
	
	public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();
        stack.push(null);
        stack.push(root);
        
        TreeNode curr = stack.peek();
        boolean rightNode = false;
        while(curr != null) {
            if(curr.left != null && !visited.contains(curr.left)) {
                visited.add(curr);
                curr = curr.left;
                stack.push(curr);
                rightNode = false;
            } else if(curr.right != null && !visited.contains(curr.right)) {
                visited.add(curr);
                curr = curr.right;
                stack.push(curr);
                rightNode = true;
            } else {
                if(!rightNode && !visited.contains(curr)) sum += curr.val;
                visited.add(curr);
                stack.pop();
                curr = stack.peek();
            }
        }
        return sum;
    }
}