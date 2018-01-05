package com.test;

import com.test.myArrayList.ListNode;
import java.util.ArrayList;
//import java.util.Stack;

public class ListSolutions {

	/*
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
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
	private ArrayList<Integer> list = new ArrayList<Integer>();
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if(listNode != null) {
			printListFromTailToHead(listNode.next);
			list.add(listNode.val);
		}
		return list;
	}
	
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        /*
        int len1 = 0, len2 = 0;
        while(p1 != null) { len1++; p1 = p1.next; }
        while(p2 != null) { len2++; p2 = p2.next; }
        p1 = pHead1; p2 = pHead2;
        int dLen;
        if(len1 > len2) {
        	dLen = len1 - len2;
        	for(int i = 0; i < dLen; i++) p1 = p1.next;
        }else {
        	dLen = len2 - len1;
        	for(int i = 0; i < dLen; i++) p2 = p2.next;
        }
        while(p1 != p2) { p1 = p1.next; p2 = p2.next; }
        */
        while(p1 != p2) {
        	p1 = (p1 == null) ? pHead2 : p1.next;
        	p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }
	
}
