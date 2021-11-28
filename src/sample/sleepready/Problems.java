package sample.sleepready;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public static List<Integer> res = new ArrayList<>();

    public static void largestValuesDFS(Trees.TreeNode root, int height){
        if(root == null) return;

        if(res.size() <= height)
            res.add(root.data);
        else
            res.set(height, Math.max(res.get(height), root.data));

        largestValuesDFS(root.left, height + 1);
        largestValuesDFS(root.right, height + 1);
    }

    public static List<Integer> largestValues(Trees.TreeNode root){
        // TC - O(V)
        // SC - O(V)
        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<Trees.TreeNode> bfs = new LinkedList<>();

        bfs.add(root);
        bfs.add(null);
        int max = Integer.MIN_VALUE;

        while(!bfs.isEmpty()){
            Trees.TreeNode cur = bfs.poll();

            if(cur != null){
                max = Math.max(max, cur.data);
                if(cur.left != null) bfs.add(cur.left);
                if(cur.right != null) bfs.add(cur.right);
            }else{
                result.add(max);
                max = Integer.MIN_VALUE;
                if(!bfs.isEmpty())
                    bfs.add(null);
            }
        }

        return result;
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
