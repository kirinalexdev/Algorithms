//package leetcode;
//
//class TreeNode {
//  int val;
//  TreeNode left;
//  TreeNode right;
//  TreeNode parent;
//  boolean done;
//
//  TreeNode() {
//  }
//
//  TreeNode(int val) {
//      this.val = val;
//  }
//
//  TreeNode(int val, TreeNode left, TreeNode right) {
//      this.val = val;
//      this.left = left;
//      this.right = right;
//      left.parent = this;
//      right.parent = this;
//  }
//}
//
//public class DiameterOfBinaryTree_draft {
//
//    // Из дерева сделать список смежности исделать обход в ширину
//
//    private static int search(TreeNode node, int count, int curCount) {
//        curCount++;
//        int res = curCount;
//        node.done = true;
//
//        if (node.parent != null && !node.parent.done) res = Math.max(search(node.parent, count, curCount), res);
//        if (node.right != null && !node.right.done) res = Math.max(search(node.right, count, curCount), res);
//        if (node.left != null && !node.left.done) res = Math.max(search(node.left, count, curCount), res);
//
//        //curCount--;
//
//        return res;
////        return Math.max(curCount + 1, Math.max(2, 3));
//    }
//
//    public static void main(String[] args) {
//        var node5 = new TreeNode(5);
//        var node4 = new TreeNode(4);
//        var node2 = new TreeNode(2, node4, node5);
//        var node3 = new TreeNode(3);
//        var node1 = new TreeNode(1, node2, node3);
//
//        System.out.println(search(node2, 0, 0));
////        System.out.println(search(node2, 0, 0));
////        System.out.println(search(node3, 0, 0));
////        System.out.println(search(node4, 0, 0));
////        System.out.println(search(node5, 0, 0));
//
////        var node3 = new TreeNode(3);
////        var node2 = new TreeNode(2, node3, null);
////        var node1 = new TreeNode(1, node2, null);
////
////        int a = 0;
////        System.out.println(search(node1, a, 0));
//    }
//
//
//}
