package com.test;

import com.test.myBinaryTree.TreeNode;

public class myBST {

	public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0) return false;
        return isBST(sequence, 0, sequence.length - 1);
    }
	
    public static boolean isBST(int[] sequence, int start, int end) {
        if(end <= start) return true;
        int i;
        for(i = start; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        for(int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
    }
    
    private TreeNode root = null;
    private TreeNode leftTail = null;
    
    myBST(TreeNode node) { root = node; }
    
    public TreeNode ConvertToOrderedDoubleLinkedList() { return ConvertToOrderedDoubleLinkedList(root); }
    
    public TreeNode ConvertToOrderedDoubleLinkedList(TreeNode node) {
        if(node == null) return null;
        if(node.left == null && node.right == null) { leftTail = node; return node; }
        TreeNode leftHead = ConvertToOrderedDoubleLinkedList(node.left);
        if(leftHead != null) {
            node.left = leftTail;
            leftTail.right = node;
        }
        leftTail = node;
        TreeNode rightHead = ConvertToOrderedDoubleLinkedList(node.right);
        if(rightHead != null) {
            node.right = rightHead;
            rightHead.left = node;
        }
        return leftHead != null ? leftHead : node;
    }
}
