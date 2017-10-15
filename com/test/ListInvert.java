package com.test;

import java.util.ArrayList;
//import java.util.Stack;

public class ListInvert {

	private ArrayList<Integer> list = new ArrayList<Integer>();
	/*
	public ArrayList<Integer> printListFromTailToHead(myArrayList.Node listNode) {
	    Stack<Integer> stack = new Stack<Integer>();
	    while(listNode != null) {
	    	stack.push(listNode.val);
	    	listNode = listNode.next;
	    }
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    while(!stack.isEmpty()) {
	    	list.add(stack.pop());
	    }
	    return list;
	}
	*/

	public ArrayList<Integer> printListFromTailToHead(myArrayList.ListNode listNode) {
		if(listNode != null) {
			printListFromTailToHead(listNode.next);
			list.add(listNode.val);
		}
		return list;
	}
	
	public void invertTheList() {
		myArrayList mylist = new myArrayList();
		mylist.add(3);
		mylist.add(6);
		mylist.add(9);
		list = printListFromTailToHead(mylist.getHead());
		System.out.println(list.toString());
	}
}
