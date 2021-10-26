package sample;

public class q4 {

    // TC - O(nlogn)
    // SC - O(n)

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    public int height(TreeNode root){
        if(root == null) return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.right) && isBalanced(root.left);
    }

}
