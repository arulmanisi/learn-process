/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
}

/**
 *
 * @author asennima
 */
public class deleteBinaryTree {
    
    
    public static void printBT(TreeNode root){
        if(root == null) return;
        List<Integer> output = new ArrayList<>();
        //List<TreeNode> delNode = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                output.add(0,curr.val);
                //delNode.add(0,curr);
                curr = curr.right;
            }
            TreeNode tmp = st.pop();
            curr = tmp.left;
        }
        
        for(int x : output){
            System.out.println(x);
        }
    }
    
    public static TreeNode deleteRecurse(TreeNode root){
        if(root == null) return root;
        
        deleteRecurse(root.left);
        deleteRecurse(root.right);        
        root = null;
        return root;
    }
        
    public static TreeNode deleteUsingRotation(TreeNode root){
        while(root != null){
            if(root.left == null) {
                TreeNode tmp = root.right;
                root = null;
                root = tmp;                
            } else {
                TreeNode pivot = root.left;
                root.left = pivot.right;
                pivot.right = root;
                root = pivot;
            }
        }
        return null;
    }
    
    public static void main(String[] args){
        
        System.out.println("Delete a binray tree");
        deleteBinaryTree obj = new deleteBinaryTree();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        printBT(root);
        root = deleteRecurse(root);
        System.out.println("\n");
        printBT(root);
        
        System.out.println("\n");
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        
        printBT(root1);
        root1 = deleteUsingRotation(root1);
        System.out.println("\n");
        printBT(root1);
    }
}
