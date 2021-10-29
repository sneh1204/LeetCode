package sample.sleepready;

import java.util.LinkedList;
import java.util.Queue;

public class Problems {

    public static Integer findMaxInTree(Trees.TreeNode root, Integer max){
        if(root == null) return max;

        max = Math.max(max, root.data);

        return Math.max(findMaxInTree(root.left, max), findMaxInTree(root.right, max));
    }

    public static int treeSizeRecursive(Trees.TreeNode root){
        if(root == null) return 0;
        return 1 + treeSizeRecursive(root.left) + treeSizeRecursive(root.right);
    }

    public static void insertElementRecursive(Trees.TreeNode root, Integer toAdd){
        if(root.data >= toAdd) {
            if (root.left == null) {
                root.left = new Trees.TreeNode(toAdd);
            } else {
                insertElementRecursive(root.right, toAdd);
            }
        }else {
            if (root.right == null) {
                root.right = new Trees.TreeNode(toAdd);
            } else {
                insertElementRecursive(root.left, toAdd);
            }
        }
    }

    public static boolean findElementRecursive(Trees.TreeNode root, Integer toFind){
        if(root == null)
            return false;

        if(root.data == toFind)
            return true;

        return findElementRecursive(root.left, toFind) || findElementRecursive(root.right, toFind);
    }

    public static Integer findMaxInTreeIterative(Trees.TreeNode root){
        // Using level order | BFS
        if(root == null)
            return Integer.MIN_VALUE;

        Queue<Trees.TreeNode> q = new LinkedList<>();
        q.offer(root);

        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            Trees.TreeNode cur = q.poll();

            max = Math.max(max, cur.data);

            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }
        }

        return max;
    }

}
