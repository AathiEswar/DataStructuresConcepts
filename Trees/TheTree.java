package Concepts.Trees;


import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}

class TreeCustom {
    TreeNode root;

    public TreeNode find(int key) {
        //creating dummy TreeNode for traversing
        TreeNode cur = root;
        if (cur == null) return null;
        //while the currentNOde data != key
        while (cur.data != key) {
            //if lesser than cur then move to left child
            if (cur.data > key) {
                cur = cur.left;
            }
            //if greater than cur then move to rightchild
            else {
                cur = cur.right;
            }
            //if not found will reach the end ie null
            if (cur == null) return null;
        }
        //if founded it will reach the TreeNode that is needed
        return cur;
    }

    public void InfixTraversal(TreeNode node) {
        if (node != null) {
            InfixTraversal(node.left);
            System.out.print(node.data + " ");
            InfixTraversal(node.right);
        }

    }

    public void PrefixTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            InfixTraversal(node.left);
            InfixTraversal(node.right);
        }
    }

    public void PostfixTraversal(TreeNode node) {
        if (node != null) {
            InfixTraversal(node.left);
            InfixTraversal(node.right);
            System.out.println(node.data + " ");
        }

    }

    public TreeNode insert(TreeNode root, int data ) {

        if(root == null){
            TreeNode newNode = new TreeNode();
            newNode.data = data;
            return newNode;
        }

        if(root.data < data){
            root.right = insert(root.right , data);
        }
        if(root.data > data){
            root.left = insert(root.left , data);
        }

        return root;

    }

    public TreeNode delete(int key , TreeNode root) {
        //if null return null
        if(root == null){
            return null;
        }
        // find the node

        if(root.data < key){
            root.right = delete(key , root.right);
        }
        else if(root.data > key){
            root.left = delete(key , root.right);
        }
        // if found
        else{
            // left node
            if(root.left == null && root.right == null){
                return null;
            }

            // node with one child
            if(root.left == null){
                return  root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            // two child
            else{
                // find successor
                TreeNode succ = root.right;

                while(succ != null){
                    succ = succ.left;
                }

                root.data  = succ.data;

                root.right = delete(key , succ);
            }


        }

        return root;
    }

    public int findMin() {
        TreeNode cur = root;
        TreeNode last = root;

        while (cur != null) {
            last = cur;
            cur = cur.left;
        }
        return last.data;
    }

    public int findMax() {
        TreeNode cur = root;
        TreeNode last = root;

        while (cur != null) {
            last = cur;
            cur = cur.right;
        }
        return last.data;
    }

    public void BFSTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                System.out.print(cur.data + " ");

                if (cur.right != null) queue.offer(cur.right);
            }
            System.out.println();
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));

    }

    public int heightOfTheTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTheTree(root.left) , heightOfTheTree(root.right));
    }
}

final class TestTheCustomTree {
    TestTheCustomTree() {
        TreeCustom tree = new TreeCustom();



        System.out.print("Infix Traversal: ");
        tree.InfixTraversal(tree.root);
        System.out.println();

        System.out.print("Prefix Traversal: ");
        tree.PrefixTraversal(tree.root);
        System.out.println();

        System.out.print("Postfix Traversal: ");
        tree.PostfixTraversal(tree.root);

        String res = tree.find(5) == null ? "Not Found" : "Found Node: " + tree.find(5).data;
        System.out.println(res);

        System.out.println("The min dataue in the tree :" + tree.findMin());
        System.out.println("The max dataue in the tree :" + tree.findMax());

        System.out.println("Deleting elements : ");

        tree.InfixTraversal(tree.root);
        System.out.println();

        System.out.println("Bfs :");
        tree.BFSTree(tree.root);

        System.out.println("MAX depth :");
        System.out.println(tree.maxDepth(tree.root));

        System.out.println("MIN depth :");
        System.out.println(tree.minDepth(tree.root));

        System.out.println("Height of the Tree");
        System.out.println(tree.heightOfTheTree(tree.root));
    }
}

public class TheTree {
    public static void main(String[] args) {
        TestTheCustomTree ttct = new TestTheCustomTree();
    }
}
