package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class myBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int v) { val = v; }
	}
	
	private TreeNode root = null;
	private int treeSize = 0;
	private ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> tempPath = new ArrayList<Integer>();
	
	myBinaryTree(TreeNode treenode) { setRoot(treenode); }
	
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
	
	myBinaryTree(String str) {
        TreeNode pRoot = null;
        if(str.length() != 0) {
        	String[] strs = str.split(",");
            Stack<TreeNode> stack = new Stack<>();
            pRoot = new TreeNode(Integer.parseInt(strs[0]));
            stack.push(pRoot);
            int len = strs.length;
            for(int i = 1; i < len; i++) {
            	TreeNode node = null;
                if(!strs[i].equals("#")) {
                    node = new TreeNode(Integer.parseInt(strs[i]));
                }
                if(strs[i - 1].equals("#")) {
                    stack.pop().right = node;
                    if(node != null) stack.push(node);
                }else {
                    stack.peek().left = node;
                    if(node != null) stack.push(node);
                }
            }
        }
        setRoot(pRoot);
	}
	
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
	
	public int GetDepth() { return GetDepth(root); }
	public int GetDepth(TreeNode node) {
        if(node == null) return 0;
        int leftDepth = GetDepth(node.left);
        int rightDepth = GetDepth(node.right);
        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }
	
	public int[] getInorder() {
		int len = treeSize;
		int[] preorder = new int[len];
		if(len != 0) {
			myBinaryTree leftTree = new myBinaryTree(root.left);
			int leftLen = leftTree.getSize();
			int[] leftIn = leftTree.getInorder();
			myBinaryTree rightTree = new myBinaryTree(root.right);
			int rightLen = rightTree.getSize();
			int[] rightIn = rightTree.getInorder();
			preorder[leftLen] = root.val;
			for(int i = 0; i < leftLen; i++) {
				preorder[i] = leftIn[i];
			}
			for(int i = 0; i < rightLen; i++) {
				preorder[leftLen + 1 + i] = rightIn[i];
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

    public ArrayList<ArrayList<Integer>> FindPathWithSum(int sum) { return FindPathWithSum(root, sum); }
    public ArrayList<ArrayList<Integer>> FindPathWithSum(TreeNode node,int target) {
        if(node == null) return paths;
        tempPath.add(node.val);
        target -= node.val;
        if(node.left == null && node.right == null && target == 0) {
            paths.add(new ArrayList<Integer>(tempPath));
            tempPath.remove(tempPath.size() - 1);
            return paths;
        }
        FindPathWithSum(node.left, target);
        FindPathWithSum(node.right, target);
        tempPath.remove(tempPath.size() - 1);
        return paths;
    }
    
    /*
    public boolean isSymmetrical() {
        return isSymmetrical(root, root);
    }
    public boolean isSymmetrical(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        return node1.val == node2.val && isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
    }
    */
    public boolean isSymmetrical() {
        if(root == null) return true;
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode p1 = q1.element();
            TreeNode p2 = q2.element();
            q1.remove();
            q2.remove();
            if(p1 == null && p2 == null) continue;
            if(p1 == null || p2 == null) return false;
            if(p1.val != p2.val) return false;
            q1.add(p1.left);
            q1.add(p1.right);
            q2.add(p2.right);
            q2.add(p2.left);
        }
        return true;
    }
    
    /*
    public ArrayList<ArrayList<Integer>> ZigZagPrint() {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        int depth = 1;
        while(!s1.isEmpty() || !s2.isEmpty()) {
        	if(depth % 2 == 1) {
        		ArrayList<Integer> list = new ArrayList<>();
        		while(!s1.isEmpty()) {
        			TreeNode node = s1.pop();
        			if(node != null) {
        				list.add(node.val);
        				s2.push(node.left);
        				s2.push(node.right);
        			}
        		}
        		if(!list.isEmpty()) {
        			res.add(list);
        			depth++;
        		}
        	}else {
        		ArrayList<Integer> list = new ArrayList<>();
        		while(!s2.isEmpty()) {
        			TreeNode node = s2.pop();
        			if(node != null) {
        				list.add(node.val);
        				s1.push(node.right);
        				s1.push(node.left);
        			}
        		}
        		if(!list.isEmpty()) {
        			res.add(list);
        			depth++;
        		}
        	}
        }
        return res;
    }
    */
    public ArrayList<ArrayList<Integer>> ZigZagPrint() {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        boolean leftToRight = true;
        queue.add(null);
        queue.add(root);
        while(queue.size() != 1) {
        	TreeNode node = queue.remove();
        	if(node == null) {
        		Iterator<TreeNode> iter = null;
        		if(leftToRight) iter = queue.iterator();
        		else iter = queue.descendingIterator();
        		leftToRight = !leftToRight;
        		while(iter.hasNext()) {
        			TreeNode temp = iter.next();
        			list.add(temp.val);
        		}
        		if(!list.isEmpty()) {
        			res.add(new ArrayList<Integer>(list));
        			list.clear();
        			queue.add(null);
        		}
        		continue;
        	}
        	if(node.left != null) queue.add(node.left);
        	if(node.right != null) queue.add(node.right);
        }
        return res;
    }
    
    public String Serialize() {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node == null) {
                sb.append("#,");
            }else {
                sb.append(node.val);
                sb.append(",");
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return sb.toString();
    }
    public TreeNode Deserialize(String str) {
        if(str.length() == 0) return null;
        String[] strs = str.split(",");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        stack.push(root);
        int len = strs.length;
        for(int i = 1; i < len; i++) {
        	TreeNode node = null;
            if(!strs[i].equals("#")) {
                node = new TreeNode(Integer.parseInt(strs[i]));
            }
            if(strs[i - 1].equals("#")) {
                stack.pop().right = node;
                if(node != null) stack.push(node);
            }else {
                stack.peek().left = node;
                if(node != null) stack.push(node);
            }
        }
        return root;
    }
    
    public TreeNode KthNode(int k) { return KthNode(root, k); }
    private int count = 0;
    /*
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if(node != null) return node;
            if(++count == k) return pRoot;
            node = KthNode(pRoot.right, k);
            if(node != null) return node;
        }
        return null;
    }
    */
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || count > k) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        while(p != null || !stack.isEmpty()) {
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            if(++count == k) return node;
            p = node.right;
        }
        return null;
    }
    
}
