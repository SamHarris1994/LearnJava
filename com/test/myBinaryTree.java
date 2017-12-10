package com.test;

import java.util.Arrays;

public class myBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int v) { val = v; }
	}
	
	private TreeNode root;
	private int treeSize;
	
	myBinaryTree() { root = null; treeSize = 0; }
	
	myBinaryTree(TreeNode treenode) {
		setRoot(treenode);
	}
	
	//** TO BE IMPROVED
	myBinaryTree(int[] arr) {
		if(arr.length == 0) root = null; treeSize = 0;
		int len = arr.length;
		TreeNode[] nodes = new TreeNode[len];
		for(int i = 0; i < len; i++) {
			if(arr[i] == Integer.MIN_VALUE) nodes[i] = null;
			else nodes[i] = new TreeNode(arr[i]);
		}
		int i = 0;
		int j = 1;
		while(j < len) {
			nodes[i].left = nodes[j];
			if(j + 1 < len) nodes[i].right = nodes[j + 1];
			++i;
			j = 2*i + 1;
		}
		root = nodes[0];
		setRoot(root);
	}
	//*/
	
	public void setRoot(TreeNode treenode) {
		root = treenode;
		if(root == null) {
			treeSize = 0;
		}else {
			treeSize = new myBinaryTree(root.left).getSize() + new myBinaryTree(root.right).getSize() + 1;
		}
	}
	
	public TreeNode getRoot() { return root; }
	
	public int getSize() { return treeSize; }
	
	public int[] getInorder() {
		int len = treeSize;
		int[] preorder = new int[len];
		if(len != 0) {
			myBinaryTree leftTree = new myBinaryTree(root.left);
			int leftLen = leftTree.getSize();
			int[] leftPre = leftTree.getInorder();
			myBinaryTree rightTree = new myBinaryTree(root.right);
			int rightLen = rightTree.getSize();
			int[] rightPre = rightTree.getInorder();
			preorder[leftLen] = root.val;
			for(int i = 0; i < leftLen; i++) {
				preorder[i] = leftPre[i];
			}
			for(int i = 0; i < rightLen; i++) {
				preorder[leftLen + 1 + i] = rightPre[i];
			}
		}
		return preorder;
	}
	
	public TreeNode reConstructFromPreorderAndInorder(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0 || pre.length != in.length) { return null; }
        
        TreeNode root = new TreeNode(pre[0]);
        int len = pre.length;
        int index = 0;
        for( ; index < len; index++) {
            if(in[index] == pre[0]) {
            	root.left = reConstructFromPreorderAndInorder(Arrays.copyOfRange(pre, 1, index + 1), 
            			Arrays.copyOfRange(in, 0, index));
                root.right = reConstructFromPreorderAndInorder(Arrays.copyOfRange(pre, index + 1, len), 
                		Arrays.copyOfRange(in, index + 1, len));
            	break;
            }
        }
        /*
        int[] leftPre = new int[index];
        int[] leftIn = new int[index];
        for(int i = 0; i < index; i++) {
            leftPre[i] = pre[i + 1];
            leftIn[i] = in[i];
        }
        root.left = reConstructFromPreorderAndInorder(leftPre, leftIn);
        
        int[] rightPre = new int[len - index - 1];
        int[] rightIn = new int[len - index - 1];
        for(int j = 0; j < len - index - 1; j++) {
            rightPre[j] = pre[index + 1 + j];
            rightIn[j] = in[index + 1 + j];
        }
        root.right = reConstructFromPreorderAndInorder(rightPre, rightIn);
        */
        return root;
    }
	
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        return IsSubtree(root1, root2) ||
            HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
	
    public boolean IsSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val == root2.val) {
            return IsSubtree(root1.left, root2.left) && IsSubtree(root1.right, root2.right);
        }else {
            return false;
        }
    }
}
