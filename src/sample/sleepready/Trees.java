package sample.sleepready;

import java.util.*;

public class Trees {

    public static class BinaryTreeNode{
        public BinaryTreeNode left, right;
        public int data;
        public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

    public static ArrayList<Integer> inOrderRecursive(BinaryTreeNode root, ArrayList<Integer> output){
        if(root == null) return output;

        inOrderRecursive(root.left, output);
        output.add(root.data);
        inOrderRecursive(root.right, output);

        return output;
    }

    public static ArrayList<Integer> postOrderRecursive(BinaryTreeNode root, ArrayList<Integer> output){
        if(root == null) return output;

        postOrderRecursive(root.left, output);
        postOrderRecursive(root.right, output);
        output.add(root.data);

        return output;
    }

    public static ArrayList<Integer> preOrderRecursive(BinaryTreeNode root, ArrayList<Integer> output){
        if(root == null) return output;

        output.add(root.data);
        preOrderRecursive(root.left, output);
        preOrderRecursive(root.right, output);

        return output;
    }

    public static ArrayList<Integer> inorderIterative(BinaryTreeNode root){
        ArrayList<Integer> output = new ArrayList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode cur = root;
        boolean done = false;
        while (!done){
            if(cur != null){ // Go to extreme left while pushing root
                s.push(cur);
                cur = cur.left;
            }else{
                if(s.isEmpty()){
                    done = true;
                }else {
                    cur = s.pop();
                    output.add(cur.data);
                    cur = cur.right;
                }
            }
        }

        return output;
    }

    public static ArrayList<Integer> dfs(BinaryTreeNode root, ArrayList<Integer> output){
        if(root == null) return output;

        output.add(root.data);

        dfs(root.left, output);
        dfs(root.right, output);

        return output;
    }

    public static ArrayList<Integer> levelOrder(BinaryTreeNode root){ // BFS
        ArrayList<Integer> output = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode last = q.poll();
            output.add(last.data);

            if(last.left != null){
                q.add(last.left);
            }

            if(last.right != null){
                q.add(last.right);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        //Sleepready
        BinaryTreeNode root = new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(4), new BinaryTreeNode(5)), new BinaryTreeNode(3, new BinaryTreeNode(6), new BinaryTreeNode(7)));
        System.out.println("Level order / BFS " + levelOrder(root));
        System.out.println("InOrder Iterative - " + inorderIterative(root));
        System.out.println("DFS - " + dfs(root, new ArrayList<>()));
        System.out.println("PreOrder Recursive - " + preOrderRecursive(root, new ArrayList<>()));
        System.out.println("PostOrder Recursive - " + postOrderRecursive(root, new ArrayList<>()));
        System.out.println("InOrder Recursive - " + inOrderRecursive(root, new ArrayList<>()));

        //Problems
        System.out.println("Find Max - " + Problems.findMaxInTree(root, Integer.MIN_VALUE));
    }

}
