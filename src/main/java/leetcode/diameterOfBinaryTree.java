package leetcode;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  int dest;

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
}

public class diameterOfBinaryTree {

    private static int search(TreeNode node, int count, int curCount) {
        curCount++;
        count = Math.max(count, curCount);

        if (node.left != null) search(node.left, count, curCount);
        if (node.right != null) search(node.right, count, curCount);

        curCount--;
        //node.dest--;

        return count;
    }

    public static void main(String[] args) {
//        var node5 = new TreeNode(5);
//        var node4 = new TreeNode(4);
//        var node2 = new TreeNode(3, node4, node5);
//        var node3 = new TreeNode(3);
//        var node1 = new TreeNode(1, node2, node2);
//        System.out.println(search(node1, 0, 0));
//        System.out.println(search(node2, 0, 0));
//        System.out.println(search(node3, 0, 0));
//        System.out.println(search(node4, 0, 0));
//        System.out.println(search(node5, 0, 0));

        var node3 = new TreeNode(3);
        var node2 = new TreeNode(2, node3, null);
        var node1 = new TreeNode(1, node2, null);

        System.out.println(search(node1, 0, 0));
    }


}
