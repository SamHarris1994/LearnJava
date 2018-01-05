package com.test;

import com.test.myArrayList.ListNode;
import com.test.myBinaryTree.TreeNode;
import com.test.RandomList.RandomListNode;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//new ListInvert().invertTheList();
		
		//System.out.println(new BinaryCode().NumberOf1(-2147483648));
		
		//System.out.println(Power(2, -3));
		
		/*
		StringMatch strmatch = new StringMatch("ABCDABD");
		int ind = strmatch.KMP("BBC ABCDAB ABCDABCDABDE");
		System.out.println(ind);
		*/
		
		/*
		int[] preorder = {1,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		myBinaryTree mytree = new myBinaryTree();
		mytree.setRoot(mytree.reConstructFromPreorderAndInorder(preorder, inorder));
		System.out.println(Arrays.toString(mytree.getInorder()));
		*/
		
		/*
		int[] values = {1, 2, 3, 4, 5};
		System.out.println(new myArrayList(values).FindKthToTail(2).val);
		*/
		
		/*
		int[][] m1 = {{1, 2}, {3, 4}};
		int[][] m2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] m3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		System.out.println(new myMatrix(m1).printMatrix());
		System.out.println(new myMatrix(m2).printMatrix());
		System.out.println(new myMatrix(m3).printMatrix());
		*/
		
		/*
		int[] arr = {10, 5, 12, 4, 7};
		System.out.print(new myBinaryTree(arr).FindPathWithSum(22).toString());
		*/
		
		/*
		RandomListNode[] rln = new RandomListNode[4];
		for(int i = 0; i < rln.length; i++) { rln[i] = new RandomListNode(i); }
		rln[0].next = rln[1]; rln[0].random = rln[2];
		rln[1].next = rln[2]; rln[1].random = rln[3];
		rln[2].next = rln[3]; rln[2].random = rln[1];
		rln[3].next = null; rln[3].random = rln[0];
		RandomListNode cloned = RandomList.Clone2(rln[0]);
		for(RandomListNode p = cloned; p != null; p = p.next) System.out.println(p.label);
		*/
		
		String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
		System.out.println(new StringSolutions().FirstNotRepeatingChar(str));
		
	}
	
	/*
	public static double Power(double base, int exponent) {
        if(exponent == 0) return 1;
        if(exponent == 1) return base;
        if(exponent < 0) return 1.0/Power(base, Math.abs(exponent));
        double temp = Power(base, exponent/2);
        if(exponent%2 == 0) return temp*temp;
        else return temp*temp*base;
    }
    */

}
