package com.test;

import java.util.ArrayList;
import com.test.myBinaryTree.TreeNode;

public class myBST {

	//private TreeNode root;
	private ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> tempPath = new ArrayList<Integer>();
	
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
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return paths;
        tempPath.add(root.val);
        target -= root.val;
        if(root.left == null && root.right == null && target == 0) {
            paths.add(new ArrayList<Integer>(tempPath));
            tempPath.remove(tempPath.size() - 1);
            return paths;
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        tempPath.remove(tempPath.size() - 1);
        return paths;
    }
}
