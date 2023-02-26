package leetcode;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        var root = createTree();
        var result = new Solution().diameterOfBinaryTree(root);
        System.out.println(result);
    }

    static TreeNode createTree(){
        var node5 = new TreeNode(5);
        var node4 = new TreeNode(4);
        var node2 = new TreeNode(2, node4, node5);
        var node3 = new TreeNode(3);
        var root = new TreeNode(1, node2, node3);

        return root;
    }
}

class Solution {
    public int longestPath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return longestPath;
    }

    public int longestPath(TreeNode root){
        if(root == null){
            return 0;
        }

        int lheight = longestPath(root.left);
        int rheight = longestPath(root.right);

        longestPath = Math.max(longestPath, lheight + rheight);

        return Math.max(lheight, rheight) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
        return ""+ val;
    }
}