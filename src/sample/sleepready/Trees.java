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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.add(this);
            q.add(null);

            sb.append("Level order tree print - \n");
            while(!q.isEmpty()){
                BinaryTreeNode last = q.poll();
                if(last != null) {
                    sb.append(last.data).append(" ");
                    if (last.left != null)
                        q.add(last.left);
                    if (last.right != null)
                        q.add(last.right);
                }else{
                    if(!q.isEmpty()) {
                        sb.append("\n");
                        q.offer(null);
                    }
                }
            }
            return sb.toString();
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

        BinaryTreeNode curr = root;
        while (!s.isEmpty() || curr != null) { // run till stack and curr both aren't empty or null
            if (curr != null) { // go to extreme left
                s.push(curr);
                curr = curr.left;
            }
            else {
                curr = s.pop();
                output.add(curr.data);

                curr = curr.right;
            }
        }

        return output;
    }

    public static ArrayList<Integer> postorderIterative(BinaryTreeNode root){
        ArrayList<Integer> output = new ArrayList<>();
        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty()){
            BinaryTreeNode cur = s1.pop();
            s2.push(cur);

            if(cur.left != null)
                s1.push(cur.left);
            if(cur.right != null)
                s1.push(cur.right);
        }

        while(!s2.isEmpty()){ // has the elements in order
            output.add(s2.pop().data);
        }

        return output;
    }

    public static ArrayList<Integer> preorderIterative(BinaryTreeNode root){
        ArrayList<Integer> output = new ArrayList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            BinaryTreeNode cur = s.pop();
            output.add(cur.data);
            if(cur.right != null)
                s.push(cur.right);
            if(cur.left != null)
                s.push(cur.left);
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

    public static ArrayList<Integer> levelOrderIterative(BinaryTreeNode root){ // BFS
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
        //Sleep ready codes
        BinaryTreeNode root = new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(4), new BinaryTreeNode(5)), new BinaryTreeNode(3, new BinaryTreeNode(6), new BinaryTreeNode(7)));
        System.out.println("***** TREES *****");
        System.out.println(root);
        System.out.println("Level order Iterative / BFS " + levelOrderIterative(root)); // easiest

        System.out.println("PreOrder Iterative - " + preorderIterative(root)); // easier than others, learn this to use
        System.out.println("InOrder Iterative - " + inorderIterative(root));
        System.out.println("PostOrder Iterative - " + postorderIterative(root)); // using 2 stacks, 1 stack is very hard

        System.out.println("PreOrder Recursive - " + preOrderRecursive(root, new ArrayList<>()));
        System.out.println("PostOrder Recursive - " + postOrderRecursive(root, new ArrayList<>()));
        System.out.println("InOrder Recursive - " + inOrderRecursive(root, new ArrayList<>()));

        System.out.println("***** GRAPHS *****");
        System.out.println("DFS - " + dfs(root, new ArrayList<>()));

        //Problems
        System.out.println("***** PROBLEMS *****");
        System.out.println("Find Max Recursive - " + Problems.findMaxInTree(root, Integer.MIN_VALUE));
        System.out.println("Find Max Iterative - " + Problems.findMaxInTreeIterative(root));
        System.out.println("Find Element Recursive - " + Problems.findElementRecursive(root, 7));

        Problems.insertElementRecursive(root, 8); // assuming root != null
        System.out.println("Insert Element Recursive - " + root);

        System.out.println("Size Recursive - " + Problems.treeSizeRecursive(root));

    }

}
