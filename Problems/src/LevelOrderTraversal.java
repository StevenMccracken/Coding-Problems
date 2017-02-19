import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
	public static void main(String[] args) {}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int level = 0;
        if(root != null) {
            list.add(new ArrayList<>());
            levelOrderRecur(root, level, list);
        }
        return list;
    }

    public static void levelOrderRecur(TreeNode pNode, int level, List<List<Integer>> list) {
        if((pNode.left != null || pNode.right != null) && list.size() <= level + 1)
            list.add(new ArrayList<>());
        list.get(level).add(pNode.val);
        if(pNode.left != null) levelOrderRecur(pNode.left, level+1, list);
        if(pNode.right != null) levelOrderRecur(pNode.right, level+1, list);
    }
}
