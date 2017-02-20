public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return mirrored(root.left, root.right);
    }

    public static boolean mirrored(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return left.val == right.val && mirrored(left.left, right.right) && mirrored(left.right, right.left);
    }
}