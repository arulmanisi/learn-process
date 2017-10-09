/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author asennima
 */
public class BinarySearchTree {

    class Node {
        int key;
        Node left,right;
        
        public Node(int item){
            key = item;
            left = null;
            right = null;
        }
    }
    
    Node root;
    
    public BinarySearchTree(){
        root = null;
    }
    
    public void insert(int item){
        //System.out.printf("Insert item %d",item);
        root = insertrec(root,item);
        //System.out.printf("Insert item %d\n",root.key);
    }
    
    private Node insertrec(Node root, int item){
        if(root == null){
            root = new Node(item);
            return root;
        }
                
        if(root.key > item){
            root.left = insertrec(root.left,item);
        }
        if(root.key < item){
            root.right = insertrec(root.right,item);
        }
        //System.out.println(root);
        //System.out.println("\n");
        return root;
    }
    
    void inorder(){
        inordertraversal(root);
    }
    
    private void inordertraversal(Node root){
        if(root != null){
            inordertraversal(root.left);
            System.out.println(root.key);
            inordertraversal(root.right);
        }
    }
    
    void delete(int key){
        root = deleteNode(root,key);
    }
    
    private Node deleteNode(Node root,int item){
        if(root == null){
            return root;
        }
        
        if(item < root.key){
            root.left = deleteNode(root.left,item);
        } else if(item > root.key){
            root.right = deleteNode(root.right,item);
        } else {
            if(root.left == null){
                
            } else if(root.right == null){
                
            }
        }
    }   
    
    private int findMinVal(Node root){
        int minv = root.key;
        while(root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    

// Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        //System.out.println("Good programming");
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        //System.out.println(50);
        tree.insert(50);
        //System.out.println(30);
        tree.insert(30);
        //System.out.println(20);
        tree.insert(20);
        //System.out.println(40);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
       // System.out.println("\n");
        tree.insert(80);
       //System.out.println("Good programming 2");
        // print inorder traversal of the BST
        //System.out.println("\n");
        tree.inorder();
                
        //System.out.println("Good programming 3");
    }
}
