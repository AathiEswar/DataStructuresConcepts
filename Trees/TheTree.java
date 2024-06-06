package Concepts.Trees;


import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;
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
                cur = cur.leftChild;
            }
            //if greater than cur then move to rightchild
            else {
                cur = cur.rightChild;
            }
            //if not found will reach the end ie null
            if (cur == null) return null;
        }
        //if founded it will reach the TreeNode that is needed
        return cur;
    }

    public void InfixTraversal(TreeNode node) {
        if (node != null) {
            InfixTraversal(node.leftChild);
            System.out.print(node.data + " ");
            InfixTraversal(node.rightChild);
        }

    }

    public void PrefixTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            InfixTraversal(node.leftChild);
            InfixTraversal(node.rightChild);
        }
    }

    public void PostfixTraversal(TreeNode node) {
        if (node != null) {
            InfixTraversal(node.leftChild);
            InfixTraversal(node.rightChild);
            System.out.println(node.data + " ");
        }

    }

    public void insert(int data) {

        TreeNode newNode = new TreeNode();
        newNode.data = data;

        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode cur = root;
        TreeNode parent;
        while (true) {
            parent = cur;
            if (data < cur.data) {
                cur = cur.leftChild;
                if (cur == null) {
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                cur = cur.rightChild;
                if (cur == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }
        }

    }

    public void delete(int key) {
        TreeNode cur = root;
        TreeNode parent = root;

        while (cur.data != key) {
            parent = cur;

            if (key < cur.data) {
                cur = cur.leftChild;
            } else {
                cur = cur.rightChild;
            }
            if (cur == null) return;

        }
        if (cur.leftChild == null && cur.rightChild == null) {
            if (cur == root) {
                root = null;
            } else if (parent.leftChild == cur) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (cur.rightChild == null) {
            if (cur == root) {
                root = cur.leftChild;

            } else if (parent.leftChild == cur) {
                parent.leftChild = cur.leftChild;
            } else {
                parent.rightChild = cur.leftChild;
            }
        } else if (cur.leftChild == null) {
            if (cur == root) {
                root = cur.rightChild;

            } else if (parent.leftChild == cur) {
                parent.leftChild = cur.rightChild;
            } else {
                parent.rightChild = cur.rightChild;
            }
        } else {
            TreeNode succParent = cur;
            TreeNode succ = cur;
            TreeNode temp = cur.rightChild;

            while (temp != null) {
                succParent = succ;
                succ = temp;
                temp = temp.leftChild;
            }
            if (succ != cur.rightChild) {
                succParent.leftChild = succ.rightChild;
                succ.rightChild = cur.rightChild;
            }
            if (cur == root) {
                root = succ;
            } else if (parent.leftChild == cur) {
                parent.leftChild = succ;
            } else {
                parent.rightChild = succ;
            }
            succ.leftChild = cur.leftChild;


        }

    }

    public int findMin() {
        TreeNode cur = root;
        TreeNode last = root;

        while (cur != null) {
            last = cur;
            cur = cur.leftChild;
        }
        return last.data;
    }

    public int findMax() {
        TreeNode cur = root;
        TreeNode last = root;

        while (cur != null) {
            last = cur;
            cur = cur.rightChild;
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
                if (cur.leftChild != null) queue.offer(cur.leftChild);
                if (cur.rightChild != null) queue.offer(cur.rightChild);
            }
            System.out.println();
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.leftChild), maxDepth(root.rightChild));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.leftChild == null && root.rightChild == null) return 1;
        if (root.leftChild == null) return 1 + minDepth(root.rightChild);
        if (root.rightChild == null) return 1 + minDepth(root.leftChild);

        return 1 + Math.min(minDepth(root.leftChild), minDepth(root.rightChild));

    }

    public int heightOfTheTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTheTree(root.leftChild) , heightOfTheTree(root.rightChild));
    }
}

final class TestTheCustomTree {
    TestTheCustomTree() {
        TreeCustom tree = new TreeCustom();
        tree.insert(25);
        tree.insert(20);
        tree.insert(36);
        tree.insert(10);
        tree.insert(22);
        tree.insert(30);
        tree.insert(40);
        tree.insert(5);
        tree.insert(12);
        tree.insert(28);
        tree.insert(38);
        tree.insert(48);


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

        System.out.println("The min value in the tree :" + tree.findMin());
        System.out.println("The max value in the tree :" + tree.findMax());

        System.out.println("Deleting elements : ");
        tree.delete(48);
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
