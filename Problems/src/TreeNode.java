public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() { this.val = 0; }
    TreeNode(int x) { this.val = x; }

    public boolean equals(TreeNode node) {
        return this.val == node.val;
    }
}